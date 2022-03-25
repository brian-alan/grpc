package com.example.grpc.service;

import com.example.grpc.proto.User;
import com.example.grpc.proto.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void hello(User.UserName request, StreamObserver<User.Respose> responseObserver) {
        String name = request.getName();
        User.Respose.Builder response = User.Respose.newBuilder();
        response.setCode(0).setGreeting("Hello! " + name);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
