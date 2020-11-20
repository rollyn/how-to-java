package com.ethanium;

import dummy.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        Greeting greeting = request.getGreeting();

        String greet = "Hello "+greeting.getFirstName();
        GreetResponse response = GreetResponse.newBuilder()
                .setResponse(greet).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetManyTimesRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        for(int i=0;i<10;i++) {
            Greeting greeting = request.getGreeting();
            String greet = "Hello "+greeting.getFirstName()+i;
            GreetManyTimesResponse response = GreetManyTimesResponse.newBuilder()
                    .setResponse(greet).build();

            responseObserver.onNext(response);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        StreamObserver<LongGreetRequest> request = new StreamObserver<LongGreetRequest>() {

            String response = "";
            @Override
            public void onNext(LongGreetRequest longGreetRequest) {
                response += "Hello " + longGreetRequest.getGreeting().getFirstName() + "\n";
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(LongGreetResponse.newBuilder()
                        .setResponse(response)
                        .build());

                responseObserver.onCompleted();
            }
        };
        return request;
    }
}
