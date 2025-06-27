package icu.xiii.springdatajpa.entity.user;

import icu.xiii.springdatajpa.dto.user.UserDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User dtoToEntity(User user, UserDtoRequest request) {
        if (request.id() != null && request.id() > 0) {
            user.setId(request.id());
        }

        if (request.name() != null && !request.name().isBlank()) {
            user.setName(request.name());
        }

        if (request.email() != null && !request.email().isBlank()) {
            user.setEmail(request.email());
        }

        return user;
    }

    public User dtoToEntity(UserDtoRequest request) {
        return dtoToEntity(new User(), request);
    }
}
