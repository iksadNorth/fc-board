package me.iksadnorth.board.repository;

import me.iksadnorth.board.domain.Commentory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentoryRepository extends JpaRepository<Commentory, Long> {
    Page<Commentory> findByPost_Id(Long postId, Pageable page);
}
