package icu.xiii.springdatajpa.entity.post;

import icu.xiii.springdatajpa.dto.post.PostDtoRequest;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public Post dtoToEntity(Post post, PostDtoRequest request) {
        if (request.id() != null && request.id() > 0) {
            post.setId(request.id());
        }

        if (request.title() != null && !request.title().isBlank()) {
            post.setTitle(request.title());
        }

        if (request.content() != null && !request.content().isBlank()) {
            post.setContent(request.content());
        }

        return post;
    }

    public Post dtoToEntity(PostDtoRequest request){
        return dtoToEntity(new Post(), request);
    }
}
