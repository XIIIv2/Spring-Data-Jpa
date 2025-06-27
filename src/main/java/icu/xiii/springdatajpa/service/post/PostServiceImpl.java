package icu.xiii.springdatajpa.service.post;

import icu.xiii.springdatajpa.dto.post.PostDtoRequest;
import icu.xiii.springdatajpa.entity.post.Post;
import icu.xiii.springdatajpa.entity.post.PostMapper;
import icu.xiii.springdatajpa.entity.user.User;
import icu.xiii.springdatajpa.repository.post.PostRepository;
import icu.xiii.springdatajpa.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service("PostService")
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {

    private final PostMapper mapper;

    private final PostRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostMapper mapper, PostRepository repository, UserRepository userRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public Post create(PostDtoRequest request){
        Objects.requireNonNull(request, "request is null");
        Post post = mapper.dtoToEntity(request);
        userRepository.findById(request.authorId()).ifPresent(author -> {
            author.addPost(post);
        });
        return repository.saveAndFlush(post);
    }

    @Override
    public Post getById(Long id) {
        Objects.requireNonNull(id, "id is null");
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    public Post updateById(Long id, PostDtoRequest request){
        Objects.requireNonNull(id, "id is null");
        Objects.requireNonNull(request, "request is null");
        Post post = repository.findById(id).orElse(null);
        return (post != null) ? repository.saveAndFlush(mapper.dtoToEntity(post, request)) :  null;
    }

    public boolean deleteById(Long id){
        Objects.requireNonNull(id, "id is null");
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Post> getByAuthorId(Long id) {
        Objects.requireNonNull(id, "id is null");
        return repository.findAllByAuthor_Id(id);
    }
}
