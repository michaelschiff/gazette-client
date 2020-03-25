package com.github.michaelschiff;

import dev.gazette.core.broker.protocol.JournalGrpc;
import dev.gazette.core.broker.protocol.Protocol;
import dev.gazette.core.broker.protocol.Protocol.ReadResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GazetteConsumer {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext();
        ManagedChannel channel = builder.build();
        JournalGrpc.JournalStub stub = JournalGrpc.newStub(channel);
        Protocol.ReadRequest readReq = Protocol.ReadRequest.newBuilder()
                .setBlock(true)
                .setOffset(0)
                .setJournal("test/part-002")
                .build();
        StreamObserver<ReadResponse> observer = new StreamObserver<ReadResponse>() {

            @Override
            public void onNext(Protocol.ReadResponse readResponse) {
                System.out.println(readResponse);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
        stub.read(readReq, observer);
        Thread.sleep(30000);
    }
}
