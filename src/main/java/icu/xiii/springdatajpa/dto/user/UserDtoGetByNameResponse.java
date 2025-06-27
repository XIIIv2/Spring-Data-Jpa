package icu.xiii.springdatajpa.dto.user;

import icu.xiii.springdatajpa.entity.user.User;
import org.springframework.http.HttpStatus;

public record UserDtoGetByNameResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        User user) {

    public static final String SUCCESS_MESSAGE = "User with name %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "User with name %s has not been found!";

    public static UserDtoGetByNameResponse of(String name, boolean isUserFound, User user) {
        if (isUserFound)
            return new UserDtoGetByNameResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(name),
                    user
            );
        else
            return new UserDtoGetByNameResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(name),
                    null
            );
    }
}
