package me.iksadnorth.board.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private User user;              // 글쓴이
    private Post post;              // 댓글이 달리는 게시글자
    private String content;         // 내용

    private LocalDateTime createdAt;    // 생성일
    private LocalDateTime createdBy;    // 생성자
    private LocalDateTime modifiedAt;   // 변경일
    private LocalDateTime modifiedBy;   // 변경
}
