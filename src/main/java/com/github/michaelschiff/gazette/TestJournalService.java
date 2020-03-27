package com.github.michaelschiff.gazette;

import com.google.protobuf.ByteString;
import dev.gazette.core.broker.protocol.JournalGrpc;
import dev.gazette.core.broker.protocol.Protocol;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TestJournalService extends JournalGrpc.JournalImplBase {

    private final Map<String, NavigableMap<Long, ByteString>> journals = new ConcurrentHashMap<>();
    private final Map<String, Long> writeHeads = new ConcurrentHashMap<>();

    public TestJournalService(Map<String, List<ByteString>> data) {
        addEvents(data);
    }

    public TestJournalService() {

    }

    public void setEvents(Map<String, List<ByteString>> data) {
        journals.clear();
        writeHeads.clear();
        addEvents(data);
    }

    //TODO(michaelschiff): double check this is right
    public void addEvents(Map<String, List<ByteString>> data) {
        for (String journal : data.keySet()) {
            NavigableMap<Long, ByteString> journalFragments = journals.getOrDefault(journal, new ConcurrentSkipListMap<>());
            long offset = writeHeads.getOrDefault(journal, 0L);
            for (ByteString fragment : data.get(journal)) {
                journalFragments.put(offset, fragment);
                offset += fragment.size();
            }
            journals.put(journal, journalFragments);
            writeHeads.put(journal, offset);
        }
    }

    @Override
    public void list(Protocol.ListRequest request, StreamObserver<Protocol.ListResponse> responseObserver) {
        Protocol.ListResponse.Builder builder = Protocol.ListResponse.newBuilder()
                .setHeader(Protocol.Header.newBuilder()) //TODO(michaelschiff): realistic header
                .setStatus(Protocol.Status.OK);
        for (String journal : journals.keySet()) {
            builder.addJournals(Protocol.ListResponse.Journal.newBuilder()
                    .setSpec(Protocol.JournalSpec.newBuilder().setName(journal)));
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void read(Protocol.ReadRequest request, StreamObserver<Protocol.ReadResponse> responseObserver) {
        String journal = request.getJournal();
        // If the requested journal does not exist
        if (!journals.containsKey(journal)) {
            responseObserver.onNext(Protocol.ReadResponse.newBuilder().setStatus(Protocol.Status.JOURNAL_NOT_FOUND).build());
            responseObserver.onCompleted();
            return;
        }

        // Find the highest offset that is less than / equal to the request offset.  This is the key
        // of the fragment that contains the requested offset.  If the key is null, there are no
        // keys yet, so we say there is no data yet.
        long offset = request.getOffset() == -1 ? Long.MAX_VALUE : request.getOffset();
        NavigableMap<Long, ByteString> journalFragments = journals.get(journal);
        Long fragmentBaseOffset = journalFragments.floorKey(offset);
        if (fragmentBaseOffset == null) {
            responseObserver.onNext(Protocol.ReadResponse.newBuilder().setStatus(Protocol.Status.OFFSET_NOT_YET_AVAILABLE).build());
            responseObserver.onCompleted();
            return;
        }
        ByteString fragment = journalFragments.get(fragmentBaseOffset);

        // The last fragment might not reach the requested offset
        if (offset > fragmentBaseOffset + fragment.size()) {
            responseObserver.onNext(Protocol.ReadResponse.newBuilder()
                    .setStatus(Protocol.Status.OFFSET_NOT_YET_AVAILABLE)
                    .setOffset(fragmentBaseOffset + fragment.size())
                    .setWriteHead(fragmentBaseOffset + fragment.size())
                    .build());
            responseObserver.onCompleted();
            return;
        }

        int relativeOffset = (int) (offset - fragmentBaseOffset); // This assumes a fragment will be < 2**32 bytes

        Protocol.ReadResponse meta = Protocol.ReadResponse.newBuilder()
                .setHeader(Protocol.Header.newBuilder()) //TODO(michaelschiff): realistic header
                .setStatus(Protocol.Status.OK)
                .setOffset(offset)
                .setWriteHead(writeHeads.get(journal)) // the current highest offset of the journal
                .setFragment(Protocol.Fragment.newBuilder()
                        .setJournal(journal)
                        .setBegin(fragmentBaseOffset)
                        .setEnd(fragment.size()) // end offset is exclusive
                )
                .setFragmentUrl("https://fragmentstore")
                .build();
        //Second part of the response is the actual fragment content.  just offset and content
        Protocol.ReadResponse content = Protocol.ReadResponse.newBuilder()
                .setHeader(Protocol.Header.newBuilder()) //TODO(michaelschiff): realistic header
                .setStatus(Protocol.Status.OK)
                .setOffset(offset) // this is the base offset of this fragment of the journal
                .setContent(fragment.substring(relativeOffset))
                .build();
        responseObserver.onNext(meta);
        responseObserver.onNext(content);
        responseObserver.onCompleted();
    }
}
