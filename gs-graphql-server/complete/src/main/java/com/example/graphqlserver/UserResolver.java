package com.example.graphqlserver;

import org.springframework.graphql.data.GraphQlRepository;

import java.lang.annotation.Annotation;

public class UserResolver implements GraphQlRepository {
    @Override
    public String typeName() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
