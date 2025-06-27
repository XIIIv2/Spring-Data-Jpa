package icu.xiii.springdatajpa.service.user;

import icu.xiii.springdatajpa.dto.user.UserDtoRequest;
import icu.xiii.springdatajpa.entity.post.Post;
import icu.xiii.springdatajpa.entity.user.User;
import icu.xiii.springdatajpa.service.BaseService;

import java.util.List;
import java.util.Set;

public interface UserService extends BaseService<User, UserDtoRequest> {

    @Override
    List<User> getAll();

    @Override
    User getById(Long id);

    @Override
    User updateById(Long id, UserDtoRequest request);

    @Override
    boolean deleteById(Long id);

    Set<Post> getPosts(Long userId);
    Set<Post> getPosts(User user);

    User getByName(String name);
    List<User> getByEmail(String email);
}
