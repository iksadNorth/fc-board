package me.iksadnorth.board.repository;

import me.iksadnorth.board.domain.Useraccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<Useraccount, Long> {
    Optional<Useraccount> findByUsername(String username);
}
