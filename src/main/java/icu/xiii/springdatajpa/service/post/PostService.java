package icu.xiii.springdatajpa.service.post;

import icu.xiii.springdatajpa.dto.post.PostDtoRequest;
import icu.xiii.springdatajpa.entity.post.Post;
import icu.xiii.springdatajpa.service.BaseService;

import java.util.List;

public interface PostService extends BaseService<Post, PostDtoRequest> {

    @Override
    List<Post> getAll();

    @Override
    Post getById(Long id);

    @Override
    Post create(PostDtoRequest request);

    @Override
    Post updateById(Long id, PostDtoRequest request);

    @Override
    boolean deleteById(Long id);

    List<Post> getByAuthorId(Long authorId);
}
