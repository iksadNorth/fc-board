package me.iksadnorth.board.domain;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private User user;              // 글쓴이
    private String content;         // 내용
    private String hashtag;         // 해시태그

    private LocalDateTime createdAt;    // 생성일
    private LocalDateTime createdBy;    // 생성자
    private LocalDateTime modifiedAt;   // 변경일자
    private LocalDateTime modifiedBy;   // 변경
}
