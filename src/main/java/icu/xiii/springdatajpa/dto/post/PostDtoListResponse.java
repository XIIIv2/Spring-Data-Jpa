package icu.xiii.springdatajpa.dto.post;

import icu.xiii.springdatajpa.entity.post.Post;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record PostDtoListResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        List<Post> posts
) {

    public static final String SUCCESS_MESSAGE = "Post list has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Post list has not been found!";

    public static PostDtoListResponse of(boolean isPostListEmpty, List<Post> postList) {
        if (isPostListEmpty)
            return new PostDtoListResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE,
                    Collections.emptyList()
            );
        else
            return new PostDtoListResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE,
                    postList
            );
    }
}
