package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.iksadnorth.board.type.RoleType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString
@Table
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Role extends AtomEntity {

    @Setter @ManyToOne
    private Useraccount useraccount;

    @Enumerated(EnumType.STRING)
    @Setter
    @Column(nullable = false)
    private RoleType roleType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return useraccount.equals(role.useraccount) && roleType == role.roleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(useraccount, roleType);
    }
}
