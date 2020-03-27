package com.github.michaelschiff.gazette;

import dev.gazette.core.broker.protocol.JournalGrpc;
import dev.gazette.core.broker.protocol.Protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Consumer {

    private final JournalGrpc.JournalBlockingStub stub;
    private final Map<String, Long> pollFrom = new HashMap<>();

    public Consumer(JournalGrpc.JournalBlockingStub stub) {
        this.stub = stub;
    }

    /**
     * @param prefix the journal prefix under which to search. Must end with a '/'
     * @return The set of journals which match the prefix
     */
    public Set<String> listJournalsForPrefix(String prefix) {
        Protocol.ListRequest listReq = Protocol.ListRequest.newBuilder()
                .setSelector(Protocol.LabelSelector.newBuilder()
                        .setInclude(Protocol.LabelSet.newBuilder().addLabels(
                                Protocol.Label.newBuilder()
                                        .setName("prefix")
                                        .setValue(prefix)
                                        .build())
                                .build())
                        .build())
                .build();
        Set<String> res = new HashSet<>();
        Protocol.ListResponse list = stub.list(listReq);
        List<Protocol.ListResponse.Journal> journalsList = list.getJournalsList();
        for (Protocol.ListResponse.Journal journal : journalsList) {
            res.add(journal.getSpec().getName());
        }
        return res;
    }

    /**
     * @param journals the set of journals this Consumer should track. Does not validate that these
     *                 journals actually exist.  This should be determined in advance (either via operator
     *                 knowledge or a call to {@link Consumer#listJournalsForPrefix}
     */
    public void assign(Set<String> journals) {
        for (String journal : journals) {
            pollFrom.put(journal, -1L);
        }
    }

    /**
     * Seek makes no attempt to correctly message align. If you are calling
     * seek it means you know the offset is message aligned.
     * @param journal the journal whose pollFrom position we are changing
     * @param offset the offset we will fetch from this journal on the next call to {@link Consumer#poll}
     */
    public void seek(String journal, long offset) {
        pollFrom.put(journal, offset);
    }

    /**
     * Sets the pollFrom offset to 0.  The 0 offset may not exist
     * but the broker will return the next highest valid offset.
     * Consumers of this API still need to check the returned offsets
     * if they are trying to guarantee that they read only a certain range
     * of offsets.
     * @param journals
     */
    public void seekToEarliest(Set<String> journals) {
        for (String journal : journals) {
            pollFrom.put(journal, 0L);
        }
    }

    /**
     * @param journals
     */
    public void seekToLatest(Set<String> journals) {
        for (String journal : journals) {
            pollFrom.put(journal, -1L);
        }
    }

    /**
     * @param journal the journal we are doing the lookup on
     * @return the offset of the current write head for the argument journal
     */
    public Long getWriteHead(String journal) {
        Protocol.ReadRequest readReq = Protocol.ReadRequest.newBuilder()
                .setOffset(-1)
                .setJournal(journal)
                .setMetadataOnly(true)
                .build();
        Iterator<Protocol.ReadResponse> read = stub.read(readReq);
        Protocol.ReadResponse metadata = read.next();
        return metadata.getWriteHead();
    }

    /**
     * @param journal the journal we are doing the lookup on
     * @return the begin offset of the lowest existing fragment
     */
    public Long getLowestValidOffset(String journal) {
        Protocol.ReadRequest readReq = Protocol.ReadRequest.newBuilder()
                .setOffset(0)
                .setJournal(journal)
                .setMetadataOnly(true)
                .build();
        Iterator<Protocol.ReadResponse> read = stub.read(readReq);
        Protocol.ReadResponse metadata = read.next();
        return metadata.getFragment().getBegin();
    }

    /**
     * @param journal the journal we are doing the lookup on
     * @return the offset from which we will try to read the argument journal on the next call to {@link Consumer#poll}
     */
    public Long getPosition(String journal) {
        return pollFrom.get(journal);
    }

    /**
     * @return the set of journals this consumer is tracking
     */
    public Set<String> getAssignment() {
        return pollFrom.keySet();
    }

    /**
     * TODO(michaelschiff):
     *     - better error handling, there are a lot of statuses not handled here
     *     - configurable max poll size, stopping at messaged aligned offsets
     * @return the list of {@link Consumer.Record} polled from the journals this consumer tracks
     */
    public List<Record> poll() {
        List<Record> polledRecords = new ArrayList<>();
        for (String journal : pollFrom.keySet()) {
            long offset = pollFrom.get(journal);
            Protocol.ReadRequest readRequest = Protocol.ReadRequest.newBuilder()
                    .setJournal(journal)
                    .setOffset(offset)
                    .build();
            Iterator<Protocol.ReadResponse> responseIter = stub.read(readRequest);
            while (responseIter.hasNext()) {
                Protocol.ReadResponse metadata = responseIter.next();
                if (Protocol.Status.OFFSET_NOT_YET_AVAILABLE.equals(metadata.getStatus())) {
                    break;
                } else if (Protocol.Status.OK.equals(metadata.getStatus())) {
                    Protocol.ReadResponse content = responseIter.next();
                    offset = metadata.getFragment().getEnd();
                    String[] recs = content.getContent().toStringUtf8().split("\n");
                    for (String rec : recs) {
                        polledRecords.add(new Record(journal, offset, rec));
                    }
                }
            }
            pollFrom.put(journal, offset);
        }
        return polledRecords;
    }

    public static class Record {
        String journal;
        long offset;
        String data;

        public Record(String journal, long offset, String data) {
            this.journal = journal;
            this.offset = offset;
            this.data = data;
        }

        public String getJournal() {
            return journal;
        }

        public long getOffset() {
            return offset;
        }

        public String getData() {
            return data;
        }
    }
}
