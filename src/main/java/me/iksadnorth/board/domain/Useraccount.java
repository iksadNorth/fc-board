package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "username"),
        @Index(columnList = "email"),
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Useraccount  extends AtomEntity {

    @Setter @Column(nullable = false)
    private String username;    // 유저명

    @Setter @Column(nullable = false)
    private String pw;    // 비밀번호

    @Setter @Column(nullable = false)
    private String email;       // 이메일

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "useraccount")
    private Set<Role> roles;
}
