package icu.xiii.springdatajpa.repository.post;

import icu.xiii.springdatajpa.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PostRepository")
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByAuthor_Id(Long authorId);
}
