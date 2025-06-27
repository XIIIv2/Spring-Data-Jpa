package icu.xiii.springdatajpa.dto.post;

public record PostDtoRequest(Long id, String title, String content, Long authorId) {
}
