package me.iksadnorth.board.dto;

import lombok.Data;
import me.iksadnorth.board.domain.Useraccount;
import me.iksadnorth.board.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UseraccountDto {

    @Autowired
    private PasswordEncoder encoder;

    private final String username;
    private final String pw;
    private final String email;
    private final Set<GrantedAuthority> roles;

    public UseraccountDto(String username, String pw, String email, Set<String> roles) {
        this.username = username;
        this.pw = encoder.encode(pw);
        this.email = email;
        this.roles = roles.stream()
                .filter(RoleType::isContained)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public void addRole(RoleType roleType) {
        roles.add(new SimpleGrantedAuthority(roleType.getName()));
    }

    public void removeRole(RoleType roleType) {
        roles.remove(new SimpleGrantedAuthority(roleType.getName()));
    }

    public static UseraccountDto from(Useraccount useraccount) {
        return null;
    }
}
