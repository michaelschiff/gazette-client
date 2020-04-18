package com.github.michaelschiff.gazette;

import dev.gazette.core.broker.protocol.JournalGrpc;
import dev.gazette.core.broker.protocol.Protocol;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestConsumer {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext();
        ManagedChannel channel = builder.build();
        JournalGrpc.JournalBlockingStub stub = JournalGrpc.newBlockingStub(channel);
        Protocol.ReadRequest readReq = Protocol.ReadRequest.newBuilder()
                .setOffset(204000)
                .setJournal("arize-edge/records/part-002")
                .setMetadataOnly(true)
                .build();
        Iterator<Protocol.ReadResponse> read = stub.read(readReq);
        System.out.println(read.next());
        System.out.println(read.next());

//        Protocol.ListRequest listReq = Protocol.ListRequest.newBuilder()
//                .setSelector(Protocol.LabelSelector.newBuilder()
//                        .setInclude(Protocol.LabelSet.newBuilder().addLabels(
//                                Protocol.Label.newBuilder()
//                                        .setName("prefix")
//                                        .setValue("arize-edge/")
//                                        .build())
//                                .build())
//                        .build())
//                .build();
//        Protocol.ListResponse list = stub.list(listReq);
//        System.out.println(list);
    }
}
