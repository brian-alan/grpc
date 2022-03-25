package com.example.grpcclient.main;

import com.example.grpcclient.proto.User;
import com.example.grpcclient.proto.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        User.UserName userName = User.UserName.newBuilder().setName("Alan").build();
        User.Respose response = userStub.hello(userName);
        System.out.println(response.getGreeting());
    }
}
