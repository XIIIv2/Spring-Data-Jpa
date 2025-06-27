package icu.xiii.springdatajpa.dto.user;

import icu.xiii.springdatajpa.entity.user.User;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record UserDtoListByEmailResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        List<User> users) {

    public static final String SUCCESS_MESSAGE = "Users with email %s has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Users with email %s has not been found!";

    public static UserDtoListByEmailResponse of(String email, List<User> users) {
        if (!users.isEmpty())
            return new UserDtoListByEmailResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true,
                    SUCCESS_MESSAGE.formatted(email),
                    users
            );
        else
            return new UserDtoListByEmailResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false,
                    FAILURE_MESSAGE.formatted(email),
                    Collections.emptyList()
            );
    }
}
