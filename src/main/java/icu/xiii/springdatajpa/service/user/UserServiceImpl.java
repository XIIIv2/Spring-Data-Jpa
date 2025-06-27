package icu.xiii.springdatajpa.service.user;

import icu.xiii.springdatajpa.dto.user.UserDtoRequest;
import icu.xiii.springdatajpa.entity.post.Post;
import icu.xiii.springdatajpa.entity.user.User;
import icu.xiii.springdatajpa.entity.user.UserMapper;
import icu.xiii.springdatajpa.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public User create(UserDtoRequest request) {
        Objects.requireNonNull(request, "request is null");
        User user = mapper.dtoToEntity(request);
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        Objects.requireNonNull(id, "id is null");
        return repository.findById(id).orElse(null);
    }

    @Override
    public User updateById(Long id, UserDtoRequest request) {
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(request, "request is null");
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            return repository.save(mapper.dtoToEntity(user, request));
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Objects.requireNonNull(id, "id is null");
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Set<Post> getPosts(Long id) {
        Objects.requireNonNull(id, "id is null");
        User user = repository.findById(id).orElse(null);
        return (user == null) ? Collections.emptySet() : user.getPosts();
    }

    public Set<Post> getPosts(User user) {
        Objects.requireNonNull(user, "user is null");
        return user.getPosts();
    }

    public User getByName(String name) {
        Objects.requireNonNull(name, "name is null");
        return repository.findByName(name);
    }

    public List<User> getByEmail(String email) {
        Objects.requireNonNull(email, "email is null");
        if (email.startsWith("@")) {
            return  repository.findAllByEmailEndsWith(email);
        }
        return List.of(repository.findByEmail(email));
    }
}
