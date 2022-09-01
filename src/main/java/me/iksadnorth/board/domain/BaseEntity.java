package me.iksadnorth.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = true)
    private LocalDateTime createdAt;   // 생성일

    @CreatedBy
    @Column(updatable = true)
    private LocalDateTime createdBy;   // 생성자

    @LastModifiedDate
    private LocalDateTime modifiedAt;  // 변경일

    @LastModifiedBy
    private LocalDateTime modifiedBy;  // 변경자
}
