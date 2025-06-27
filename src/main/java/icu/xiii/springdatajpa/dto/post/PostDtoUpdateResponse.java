package icu.xiii.springdatajpa.dto.post;

import icu.xiii.springdatajpa.entity.post.Post;
import org.springframework.http.HttpStatus;

public record PostDtoUpdateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Post post) {

    public static final String SUCCESS_MESSAGE = "Post with id %s has been updated successfully.";
    public static final String FAILURE_MESSAGE = "Post with id %s has not been found!";

    public static PostDtoUpdateResponse of(Long id, boolean isPostFound, Post postUpdated) {
        if (isPostFound)
            return new PostDtoUpdateResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(id),
                    postUpdated
            );
        else
            return new PostDtoUpdateResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(id),
                    null
            );
    }
}

