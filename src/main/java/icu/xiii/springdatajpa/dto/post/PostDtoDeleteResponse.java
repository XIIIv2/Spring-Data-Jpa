package icu.xiii.springdatajpa.dto.post;

import org.springframework.http.HttpStatus;

public record PostDtoDeleteResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Post with id %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Post with id %s has not been found!";

    public static PostDtoDeleteResponse of(Long id, boolean isPostFound) {
        if (isPostFound)
            return new PostDtoDeleteResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(id)
            );
        else
            return new PostDtoDeleteResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(id)
            );
    }
}