package com.example.graphqlserver;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class BookController {

    private final RestTemplate restTemplate;

    public BookController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Tag(name = "Testing")
    @QueryMapping
    public GraphQLResponse<Book> bookById(@Argument String id) {
        Book book = Book.getById(id);
        if (book != null) {
            return new GraphQLResponse<>("success", book);
        } else {
            return new GraphQLResponse<>("failure", null);
        }
    }

    @SchemaMapping
    public Author author(Book book) {
        String API_URL = "https://jsonplaceholder.typicode.com/posts/1";
        Post post = restTemplate.getForObject(API_URL, Post.class);

        System.out.println(post.toString());
        assert post != null;
        return Author.getById(book.authorId());
    }


    class Post {
        private int userId;
        private int id;
        private String title;
        private String body;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}