package com.example.graphqlserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class BookRestController {

    @GetMapping
    public String test() {
        return "Hi there from graphql server";
    }
}