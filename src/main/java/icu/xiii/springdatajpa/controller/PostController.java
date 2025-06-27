package icu.xiii.springdatajpa.controller;

import icu.xiii.springdatajpa.dto.post.*;
import icu.xiii.springdatajpa.dto.user.*;
import icu.xiii.springdatajpa.entity.post.Post;
import icu.xiii.springdatajpa.entity.user.User;
import icu.xiii.springdatajpa.service.post.PostService;
import icu.xiii.springdatajpa.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/v1/posts"))
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PostDtoCreateResponse> createPost(@RequestBody PostDtoRequest request) {
        Post post = service.create(request);
        return ResponseEntity.ok(PostDtoCreateResponse.of(post != null, post));
    }

    @GetMapping
    public ResponseEntity<PostDtoListResponse> getAllPosts() {
        List<Post> posts = service.getAll();
        return ResponseEntity.ok(PostDtoListResponse.of(posts.isEmpty(), posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDtoGetByIdResponse> getPostById(@PathVariable("id") Long id) {
        Post post = service.getById(id);
        return ResponseEntity.ok(PostDtoGetByIdResponse.of(id, post != null, post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDtoUpdateResponse> updatePostById(@PathVariable("id") Long id, @RequestBody PostDtoRequest request) {
        Post post = service.updateById(id, request);
        return ResponseEntity.ok(PostDtoUpdateResponse.of(id, post != null, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDtoDeleteResponse> deletePostById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(PostDtoDeleteResponse.of(id, service.deleteById(id)));
    }
}
