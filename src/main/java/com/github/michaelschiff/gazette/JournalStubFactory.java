package com.github.michaelschiff.gazette;

import dev.gazette.core.broker.protocol.JournalGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JournalStubFactory {

    private static Map<String, ManagedChannel> channels = new ConcurrentHashMap<>();

    public static JournalGrpc.JournalBlockingStub newBlockingStub(String endpoint) {
        ManagedChannel channel;
        if (!channels.containsKey(endpoint)) {
            ManagedChannelBuilder<?> builder = ManagedChannelBuilder.forTarget(endpoint).usePlaintext();
            channel = builder.build();
            channels.put(endpoint, channel);
        } else {
            channel = channels.get(endpoint);
        }
        return JournalGrpc.newBlockingStub(channel);
    }
}
