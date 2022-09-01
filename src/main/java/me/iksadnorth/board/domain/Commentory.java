package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Commentory extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Useraccount useraccount;              // 글쓴이

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Post post;              // 댓글이 달리는 게시글자

    @Setter @Column(length = 10000)
    private String content;         // 내용

    public Commentory() {
    }

    public Commentory(Useraccount useraccount, Post post, String content) {
        this.useraccount = useraccount;
        this.post = post;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentory commentory = (Commentory) o;
        return id.equals(commentory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
