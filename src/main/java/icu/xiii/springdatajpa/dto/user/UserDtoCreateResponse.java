package icu.xiii.springdatajpa.dto.user;

import icu.xiii.springdatajpa.entity.user.User;
import org.springframework.http.HttpStatus;

public record UserDtoCreateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        User user) {

    public static final String SUCCESS_MESSAGE = "User has been created successfully.";
    public static final String FAILURE_MESSAGE = "User has not been created!";

    public static UserDtoCreateResponse of(boolean isUserCreated, User user) {
        // ternary operator usage
        return (isUserCreated) ?
                new UserDtoCreateResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true,
                        SUCCESS_MESSAGE,
                        user
                ) :
                new UserDtoCreateResponse(
                        HttpStatus.NO_CONTENT.value(),
                        HttpStatus.NO_CONTENT.getReasonPhrase(),
                        false,
                        FAILURE_MESSAGE,
                        null
                );
    }
}
