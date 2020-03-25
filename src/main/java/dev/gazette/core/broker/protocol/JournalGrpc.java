package dev.gazette.core.broker.protocol;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Journal is the Gazette broker service API for interacting with Journals.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: protocol.proto")
public final class JournalGrpc {

  private JournalGrpc() {}

  public static final String SERVICE_NAME = "protocol.Journal";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ListRequest,
      dev.gazette.core.broker.protocol.Protocol.ListResponse> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = dev.gazette.core.broker.protocol.Protocol.ListRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ListRequest,
      dev.gazette.core.broker.protocol.Protocol.ListResponse> getListMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ListRequest, dev.gazette.core.broker.protocol.Protocol.ListResponse> getListMethod;
    if ((getListMethod = JournalGrpc.getListMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getListMethod = JournalGrpc.getListMethod) == null) {
          JournalGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.ListRequest, dev.gazette.core.broker.protocol.Protocol.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ApplyRequest,
      dev.gazette.core.broker.protocol.Protocol.ApplyResponse> getApplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Apply",
      requestType = dev.gazette.core.broker.protocol.Protocol.ApplyRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.ApplyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ApplyRequest,
      dev.gazette.core.broker.protocol.Protocol.ApplyResponse> getApplyMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ApplyRequest, dev.gazette.core.broker.protocol.Protocol.ApplyResponse> getApplyMethod;
    if ((getApplyMethod = JournalGrpc.getApplyMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getApplyMethod = JournalGrpc.getApplyMethod) == null) {
          JournalGrpc.getApplyMethod = getApplyMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.ApplyRequest, dev.gazette.core.broker.protocol.Protocol.ApplyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Apply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ApplyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ApplyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("Apply"))
              .build();
        }
      }
    }
    return getApplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReadRequest,
      dev.gazette.core.broker.protocol.Protocol.ReadResponse> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = dev.gazette.core.broker.protocol.Protocol.ReadRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.ReadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReadRequest,
      dev.gazette.core.broker.protocol.Protocol.ReadResponse> getReadMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReadRequest, dev.gazette.core.broker.protocol.Protocol.ReadResponse> getReadMethod;
    if ((getReadMethod = JournalGrpc.getReadMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getReadMethod = JournalGrpc.getReadMethod) == null) {
          JournalGrpc.getReadMethod = getReadMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.ReadRequest, dev.gazette.core.broker.protocol.Protocol.ReadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ReadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("Read"))
              .build();
        }
      }
    }
    return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.AppendRequest,
      dev.gazette.core.broker.protocol.Protocol.AppendResponse> getAppendMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Append",
      requestType = dev.gazette.core.broker.protocol.Protocol.AppendRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.AppendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.AppendRequest,
      dev.gazette.core.broker.protocol.Protocol.AppendResponse> getAppendMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.AppendRequest, dev.gazette.core.broker.protocol.Protocol.AppendResponse> getAppendMethod;
    if ((getAppendMethod = JournalGrpc.getAppendMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getAppendMethod = JournalGrpc.getAppendMethod) == null) {
          JournalGrpc.getAppendMethod = getAppendMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.AppendRequest, dev.gazette.core.broker.protocol.Protocol.AppendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Append"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.AppendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.AppendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("Append"))
              .build();
        }
      }
    }
    return getAppendMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest,
      dev.gazette.core.broker.protocol.Protocol.ReplicateResponse> getReplicateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Replicate",
      requestType = dev.gazette.core.broker.protocol.Protocol.ReplicateRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.ReplicateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest,
      dev.gazette.core.broker.protocol.Protocol.ReplicateResponse> getReplicateMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest, dev.gazette.core.broker.protocol.Protocol.ReplicateResponse> getReplicateMethod;
    if ((getReplicateMethod = JournalGrpc.getReplicateMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getReplicateMethod = JournalGrpc.getReplicateMethod) == null) {
          JournalGrpc.getReplicateMethod = getReplicateMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest, dev.gazette.core.broker.protocol.Protocol.ReplicateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Replicate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ReplicateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.ReplicateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("Replicate"))
              .build();
        }
      }
    }
    return getReplicateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.FragmentsRequest,
      dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> getListFragmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFragments",
      requestType = dev.gazette.core.broker.protocol.Protocol.FragmentsRequest.class,
      responseType = dev.gazette.core.broker.protocol.Protocol.FragmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.FragmentsRequest,
      dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> getListFragmentsMethod() {
    io.grpc.MethodDescriptor<dev.gazette.core.broker.protocol.Protocol.FragmentsRequest, dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> getListFragmentsMethod;
    if ((getListFragmentsMethod = JournalGrpc.getListFragmentsMethod) == null) {
      synchronized (JournalGrpc.class) {
        if ((getListFragmentsMethod = JournalGrpc.getListFragmentsMethod) == null) {
          JournalGrpc.getListFragmentsMethod = getListFragmentsMethod =
              io.grpc.MethodDescriptor.<dev.gazette.core.broker.protocol.Protocol.FragmentsRequest, dev.gazette.core.broker.protocol.Protocol.FragmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFragments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.FragmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dev.gazette.core.broker.protocol.Protocol.FragmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JournalMethodDescriptorSupplier("ListFragments"))
              .build();
        }
      }
    }
    return getListFragmentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JournalStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JournalStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JournalStub>() {
        @java.lang.Override
        public JournalStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JournalStub(channel, callOptions);
        }
      };
    return JournalStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JournalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JournalBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JournalBlockingStub>() {
        @java.lang.Override
        public JournalBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JournalBlockingStub(channel, callOptions);
        }
      };
    return JournalBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JournalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JournalFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JournalFutureStub>() {
        @java.lang.Override
        public JournalFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JournalFutureStub(channel, callOptions);
        }
      };
    return JournalFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Journal is the Gazette broker service API for interacting with Journals.
   * </pre>
   */
  public static abstract class JournalImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * List Journals, their JournalSpecs and current Routes.
     * </pre>
     */
    public void list(dev.gazette.core.broker.protocol.Protocol.ListRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     * <pre>
     * Apply changes to the collection of Journals managed by the brokers.
     * </pre>
     */
    public void apply(dev.gazette.core.broker.protocol.Protocol.ApplyRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ApplyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getApplyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Read from a specific Journal.
     * </pre>
     */
    public void read(dev.gazette.core.broker.protocol.Protocol.ReadRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Append content to a specific Journal.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.AppendRequest> append(
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.AppendResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAppendMethod(), responseObserver);
    }

    /**
     * <pre>
     * Replicate appended content of a Journal. Replicate is used between broker
     * peers in the course of processing Append transactions, but is not intended
     * for direct use by clients.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest> replicate(
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReplicateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getReplicateMethod(), responseObserver);
    }

    /**
     * <pre>
     * List Fragments of a Journal.
     * </pre>
     */
    public void listFragments(dev.gazette.core.broker.protocol.Protocol.FragmentsRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListFragmentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.ListRequest,
                dev.gazette.core.broker.protocol.Protocol.ListResponse>(
                  this, METHODID_LIST)))
          .addMethod(
            getApplyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.ApplyRequest,
                dev.gazette.core.broker.protocol.Protocol.ApplyResponse>(
                  this, METHODID_APPLY)))
          .addMethod(
            getReadMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.ReadRequest,
                dev.gazette.core.broker.protocol.Protocol.ReadResponse>(
                  this, METHODID_READ)))
          .addMethod(
            getAppendMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.AppendRequest,
                dev.gazette.core.broker.protocol.Protocol.AppendResponse>(
                  this, METHODID_APPEND)))
          .addMethod(
            getReplicateMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.ReplicateRequest,
                dev.gazette.core.broker.protocol.Protocol.ReplicateResponse>(
                  this, METHODID_REPLICATE)))
          .addMethod(
            getListFragmentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                dev.gazette.core.broker.protocol.Protocol.FragmentsRequest,
                dev.gazette.core.broker.protocol.Protocol.FragmentsResponse>(
                  this, METHODID_LIST_FRAGMENTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Journal is the Gazette broker service API for interacting with Journals.
   * </pre>
   */
  public static final class JournalStub extends io.grpc.stub.AbstractAsyncStub<JournalStub> {
    private JournalStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JournalStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JournalStub(channel, callOptions);
    }

    /**
     * <pre>
     * List Journals, their JournalSpecs and current Routes.
     * </pre>
     */
    public void list(dev.gazette.core.broker.protocol.Protocol.ListRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Apply changes to the collection of Journals managed by the brokers.
     * </pre>
     */
    public void apply(dev.gazette.core.broker.protocol.Protocol.ApplyRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ApplyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getApplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Read from a specific Journal.
     * </pre>
     */
    public void read(dev.gazette.core.broker.protocol.Protocol.ReadRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReadResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Append content to a specific Journal.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.AppendRequest> append(
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.AppendResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAppendMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Replicate appended content of a Journal. Replicate is used between broker
     * peers in the course of processing Append transactions, but is not intended
     * for direct use by clients.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReplicateRequest> replicate(
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReplicateResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getReplicateMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * List Fragments of a Journal.
     * </pre>
     */
    public void listFragments(dev.gazette.core.broker.protocol.Protocol.FragmentsRequest request,
        io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFragmentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Journal is the Gazette broker service API for interacting with Journals.
   * </pre>
   */
  public static final class JournalBlockingStub extends io.grpc.stub.AbstractBlockingStub<JournalBlockingStub> {
    private JournalBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JournalBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JournalBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * List Journals, their JournalSpecs and current Routes.
     * </pre>
     */
    public dev.gazette.core.broker.protocol.Protocol.ListResponse list(dev.gazette.core.broker.protocol.Protocol.ListRequest request) {
      return blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Apply changes to the collection of Journals managed by the brokers.
     * </pre>
     */
    public dev.gazette.core.broker.protocol.Protocol.ApplyResponse apply(dev.gazette.core.broker.protocol.Protocol.ApplyRequest request) {
      return blockingUnaryCall(
          getChannel(), getApplyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Read from a specific Journal.
     * </pre>
     */
    public java.util.Iterator<dev.gazette.core.broker.protocol.Protocol.ReadResponse> read(
        dev.gazette.core.broker.protocol.Protocol.ReadRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List Fragments of a Journal.
     * </pre>
     */
    public dev.gazette.core.broker.protocol.Protocol.FragmentsResponse listFragments(dev.gazette.core.broker.protocol.Protocol.FragmentsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFragmentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Journal is the Gazette broker service API for interacting with Journals.
   * </pre>
   */
  public static final class JournalFutureStub extends io.grpc.stub.AbstractFutureStub<JournalFutureStub> {
    private JournalFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JournalFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JournalFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * List Journals, their JournalSpecs and current Routes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.gazette.core.broker.protocol.Protocol.ListResponse> list(
        dev.gazette.core.broker.protocol.Protocol.ListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Apply changes to the collection of Journals managed by the brokers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.gazette.core.broker.protocol.Protocol.ApplyResponse> apply(
        dev.gazette.core.broker.protocol.Protocol.ApplyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getApplyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List Fragments of a Journal.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<dev.gazette.core.broker.protocol.Protocol.FragmentsResponse> listFragments(
        dev.gazette.core.broker.protocol.Protocol.FragmentsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFragmentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST = 0;
  private static final int METHODID_APPLY = 1;
  private static final int METHODID_READ = 2;
  private static final int METHODID_LIST_FRAGMENTS = 3;
  private static final int METHODID_APPEND = 4;
  private static final int METHODID_REPLICATE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JournalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JournalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST:
          serviceImpl.list((dev.gazette.core.broker.protocol.Protocol.ListRequest) request,
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ListResponse>) responseObserver);
          break;
        case METHODID_APPLY:
          serviceImpl.apply((dev.gazette.core.broker.protocol.Protocol.ApplyRequest) request,
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ApplyResponse>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((dev.gazette.core.broker.protocol.Protocol.ReadRequest) request,
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReadResponse>) responseObserver);
          break;
        case METHODID_LIST_FRAGMENTS:
          serviceImpl.listFragments((dev.gazette.core.broker.protocol.Protocol.FragmentsRequest) request,
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.FragmentsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_APPEND:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.append(
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.AppendResponse>) responseObserver);
        case METHODID_REPLICATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.replicate(
              (io.grpc.stub.StreamObserver<dev.gazette.core.broker.protocol.Protocol.ReplicateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class JournalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JournalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dev.gazette.core.broker.protocol.Protocol.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Journal");
    }
  }

  private static final class JournalFileDescriptorSupplier
      extends JournalBaseDescriptorSupplier {
    JournalFileDescriptorSupplier() {}
  }

  private static final class JournalMethodDescriptorSupplier
      extends JournalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JournalMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JournalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JournalFileDescriptorSupplier())
              .addMethod(getListMethod())
              .addMethod(getApplyMethod())
              .addMethod(getReadMethod())
              .addMethod(getAppendMethod())
              .addMethod(getReplicateMethod())
              .addMethod(getListFragmentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
