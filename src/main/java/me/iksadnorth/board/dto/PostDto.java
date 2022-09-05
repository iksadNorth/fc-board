package me.iksadnorth.board.dto;

import lombok.Data;
import me.iksadnorth.board.domain.Post;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PostDto implements Serializable {
    private final Long id;
    private final String title;
    private final String content;
    private final String hashtag;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static PostDto of(Long id, String title, String content, String hashtag) {
        return new PostDto(id, title, content, hashtag, null, null, null, null);
    }

    public static PostDto of(String title, String content, String hashtag) {
        return PostDto.of(null, title, content, hashtag);
    }

    public static PostDto from(Post entityPost) {
        return new PostDto(
        entityPost.getId(),
        entityPost.getTitle(),
        entityPost.getContent(),
        entityPost.getHashtag(),
        entityPost.getCreatedAt(),
        entityPost.getCreatedBy(),
        entityPost.getModifiedAt(),
        entityPost.getModifiedBy()
        );
    }

    public static Post toEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setHashtag(postDto.getHashtag());
        return post;
    }
}
