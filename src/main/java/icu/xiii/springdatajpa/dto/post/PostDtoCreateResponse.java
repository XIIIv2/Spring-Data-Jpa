package icu.xiii.springdatajpa.dto.post;

import icu.xiii.springdatajpa.entity.post.Post;
import org.springframework.http.HttpStatus;

public record PostDtoCreateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Post post) {

    public static final String SUCCESS_MESSAGE = "Post has been created successfully.";
    public static final String FAILURE_MESSAGE = "Post has not been created!";

    public static PostDtoCreateResponse of(boolean isPostCreated, Post post) {
        // ternary operator usage
        return (isPostCreated) ?
                new PostDtoCreateResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true,
                        SUCCESS_MESSAGE,
                        post
                ) :
                new PostDtoCreateResponse(
                        HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.getReasonPhrase(),
                        false,
                        FAILURE_MESSAGE,
                        null
                );
    }
}
