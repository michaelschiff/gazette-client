package com.github.michaelschiff;

import dev.gazette.core.broker.protocol.JournalGrpc;
import dev.gazette.core.broker.protocol.Protocol;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GazetteConsumer {

    public static void main(String[] args) {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext();
        ManagedChannel channel = builder.build();
        JournalGrpc.JournalBlockingStub stub = JournalGrpc.newBlockingStub(channel);
        Protocol.LabelSelector labelSelector = Protocol.LabelSelector.newBuilder()
                .setInclude(Protocol.LabelSet.newBuilder()
                        .addLabels(Protocol.Label.newBuilder()
                                .setName("prefix")
                                .setValue("test/")
                                .build()))
                .build();
        Protocol.ListRequest listReq = Protocol.ListRequest.newBuilder()
                .setSelector(labelSelector)
                .build();
        Protocol.ListResponse list = stub.list(listReq);
        System.out.println(list);
    }
}
