package me.iksadnorth.board.repository;

import me.iksadnorth.board.domain.Useraccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<Useraccount, Long> {
}
