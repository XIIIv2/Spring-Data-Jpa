package icu.xiii.springdatajpa.dto.user;

import icu.xiii.springdatajpa.entity.user.User;
import org.springframework.http.HttpStatus;

public record UserDtoGetByEmailResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        User user) {

    public static final String SUCCESS_MESSAGE = "User with email %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "User with email %s has not been found!";

    public static UserDtoGetByEmailResponse of(String email, boolean isUserFound, User user) {
        if (isUserFound)
            return new UserDtoGetByEmailResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(email),
                    user
            );
        else
            return new UserDtoGetByEmailResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(email),
                    null
            );
    }
}
