package me.iksadnorth.board.repository;

import me.iksadnorth.board.domain.Commentory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentoryRepository extends JpaRepository<Commentory, Long> {
}
