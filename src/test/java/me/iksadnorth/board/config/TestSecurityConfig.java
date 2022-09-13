package me.iksadnorth.board.config;

import me.iksadnorth.board.domain.Useraccount;
import me.iksadnorth.board.repository.UserAccountRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {
    @MockBean
    private UserAccountRepository repo;

    @BeforeTestMethod
    public void  securitySetUp() {
        given(repo.findByUsername(anyString())).willReturn(Optional.of(Useraccount.of(
                "iksad",
                "q1w2e3r4$$",
                "iksadnorth@gmail.com"
        )));
    }
}
