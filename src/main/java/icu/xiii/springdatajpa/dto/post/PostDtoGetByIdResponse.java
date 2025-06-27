package icu.xiii.springdatajpa.dto.post;

import icu.xiii.springdatajpa.entity.post.Post;
import org.springframework.http.HttpStatus;

public record PostDtoGetByIdResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Post post) {

    public static final String SUCCESS_MESSAGE = "Post with id %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Post with id %s has not been found!";

    public static PostDtoGetByIdResponse of(Long id, boolean isPostFound, Post post) {
        if (isPostFound)
            return new PostDtoGetByIdResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(id),
                    post
            );
        else
            return new PostDtoGetByIdResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(id),
                    null
            );
    }
}
