package me.iksadnorth.board.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CommentoryDto implements Serializable {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static CommentoryDto of(Long id, String content) {
        return new CommentoryDto(id, content, null, null, null, null);
    }

    public static CommentoryDto of(String content) {
        return new CommentoryDto(null, content, null, null, null, null);
    }
}
