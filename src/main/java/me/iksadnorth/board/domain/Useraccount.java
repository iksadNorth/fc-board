package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "username"),
        @Index(columnList = "email"),
})
@Entity
public class Useraccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false)
    private String username;    // 유저명

    @Setter @Column(nullable = false)
    private String email;       // 이메일
}
