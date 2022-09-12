package me.iksadnorth.board.repository;

import me.iksadnorth.board.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
    Page<Post> findByUseraccount_UsernameContaining(String keyword, Pageable pageable);
    Page<Post> findByContentContaining(String keyword, Pageable pageable);
    Page<Post> findByHashtagContaining(String keyword, Pageable pageable);
}
