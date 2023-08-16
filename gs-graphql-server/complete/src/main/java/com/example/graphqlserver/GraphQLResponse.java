package com.example.graphqlserver;

public class GraphQLResponse<T> {
    private String status;
    private T data;

    public GraphQLResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
