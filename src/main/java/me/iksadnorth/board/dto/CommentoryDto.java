package me.iksadnorth.board.dto;

import lombok.Data;
import me.iksadnorth.board.domain.Commentory;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CommentoryDto implements Serializable {
    private final Long id;
    private final Long postId;
    private final String content;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static CommentoryDto of(Long id, String content, LocalDateTime createdAt, String createdBy) {
        return new CommentoryDto(id, null, content, createdAt, createdBy, null, null);
    }

    public static CommentoryDto of(Long id, String content) {
        return new CommentoryDto(id, null, content, null, null, null, null);
    }

    public static CommentoryDto of(String content) {
        return new CommentoryDto(null, null, content, null, null, null, null);
    }

    public Commentory toEntity() {
        Commentory commentory = new Commentory();
        commentory.setContent(content);
        return commentory;
    }

    public static CommentoryDto from(Commentory entity) {
        return CommentoryDto.of(
                entity.getId(),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getCreatedBy()
        );
    }

    public CommentoryDto with(Long postId) {
        return new CommentoryDto(
                this.id,
                postId,
                this.content,
                this.createdAt,
                this.createdBy,
                this.modifiedAt,
                this.modifiedBy
        );
    }
}
