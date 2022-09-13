package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Useraccount useraccount;              // 글쓴이

    @Setter @Column(nullable = false)
    private String title;           // 제목

    @Setter @Column(length = 10000)
    private String content;         // 내용

    @Setter @Column(length = 100)
    private String hashtag;         // 해시태그

    public Post() {
    }

    public Post(Useraccount useraccount, String title, String content, String hashtag) {
        this.useraccount = useraccount;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public Post of(Useraccount useraccount, String title, String content, String hashtag) {
        return new Post(useraccount, title, content, hashtag);
    }
}
