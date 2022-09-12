package me.iksadnorth.board.repository;

import lombok.extern.slf4j.Slf4j;
import me.iksadnorth.board.domain.Commentory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayName("직접 생성한 메서드들에 관한 검증.")
@DataJpaTest
class CommentoryRepositoryTest {
    @Autowired
    private CommentoryRepository repo;

    @DisplayName("댓글을 로드할 수 있는지 확인.")
    @Test
    public void givenId_whenFindingById_thenGivesComment() {
        // given
        Long id = 1L;

        // when
        Optional<Commentory> comments = repo.findById(id);

        // then
        log.trace(comments.orElse(new Commentory()).toString());
        assertThat(comments).isNotEmpty();

    }

    @DisplayName("특정 게시물에 속한 댓글들만 로드할 수 있는지 확인.")
    @Test
    public void givenPostIdAndPage_whenFindingByPost_Id_thenGivesCommentsInPost() {
        // given
        Pageable page = PageRequest.of(0, 5, Sort.by("createdAt").descending());

        // when
        Page<Commentory> comments = repo.findByPost_Id(1L, page);

        // then
        log.trace("Start Print!!!");
        comments.get().map(Object::toString).forEach(log::trace);
        assertThat(comments).isNotEmpty();

    }

}