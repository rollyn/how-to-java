package com.ethanium;

import dummy.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    ManagedChannel channel;

    void init() {
        channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext().build();
    }

    void close() {
        channel.shutdown();
    }

    void doUnary(ManagedChannel channel) {

        GreetServiceGrpc.GreetServiceBlockingStub syncClient =
                GreetServiceGrpc.newBlockingStub(channel);

        GreetRequest request = GreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("ROLLYN")
                        .setLastName("MOISES").build()
                ).build();

        GreetResponse response = syncClient.greet(request);
        System.out.println( response.getResponse() );
    }

    void doStreamSerever(ManagedChannel channel) {

        GreetServiceGrpc.GreetServiceBlockingStub syncClient =
                GreetServiceGrpc.newBlockingStub(channel);
        GreetManyTimesRequest request = GreetManyTimesRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("ROLLYN")
                        .setLastName("MOISES").build()
                ).build();

        Iterator<GreetManyTimesResponse> response = syncClient.greetManyTimes(request);

        response.forEachRemaining(System.out::print);
    }

    void doStreamClient(ManagedChannel channel)  {

        GreetServiceGrpc.GreetServiceStub asyncClient =
                GreetServiceGrpc.newStub(channel);

        LongGreetRequest request = LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("ROLLYN")
                        .setLastName("MOISES").build()
                ).build();

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> longGreetRequestStreamObserver
                = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {

            @Override
            public void onNext(LongGreetResponse longGreetResponse) {
                System.out.println("RESPONSE");
                System.out.println(longGreetResponse.getResponse());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("DONE.");
                latch.countDown();
            }
        });

        longGreetRequestStreamObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("ROLLYN")
                        .setLastName("MOISES").build()
                ).build()
        );
        longGreetRequestStreamObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("JOY")
                        .setLastName("MOISES").build()
                ).build()
        );
        longGreetRequestStreamObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("CHENILLE")
                        .setLastName("MOISES").build()
                ).build()
        );
        longGreetRequestStreamObserver.onNext(LongGreetRequest.newBuilder()
                .setGreeting(Greeting.newBuilder()
                        .setFirstName("ETHAN")
                        .setLastName("MOISES").build()
                ).build()
        );

        longGreetRequestStreamObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // bi-directional
    private void doBiStreaming(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestObserver = asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                System.out.println("Response from server: " + value.getResponse());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data");
                latch.countDown();
            }
        });

        Arrays.asList("Stephane", "John", "Marc", "Patricia").forEach(
                name -> {
                    System.out.println("Sending: " + name);
                    requestObserver.onNext(GreetEveryoneRequest.newBuilder()
                            .setGreeting(Greeting.newBuilder()
                                    .setFirstName(name))
                            .build());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        requestObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("GRPC Client");

        GreetingClient client = new GreetingClient();
        client.init();

//        client.doUnary(client.channel);

//        client.doStreamClient(client.channel);

        client.doBiStreaming(client.channel);
        client.close();


//        GreetServiceGrpc.GreetServiceFutureStub asyncClient =
//                GreetServiceGrpc.newFutureStub(channel);



    }

}
