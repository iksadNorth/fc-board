package me.iksadnorth.board.repository;

import lombok.extern.slf4j.Slf4j;
import me.iksadnorth.board.config.TestJpaConfig;
import me.iksadnorth.board.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DisplayName("직접 생성한 메서드들에 관한 검증.")
@Import({TestJpaConfig.class})
@DataJpaTest
class PostRepositoryTest {
    @Autowired
    private PostRepository repo;

    private final Pageable page = PageRequest.of(0, 5, Sort.by("createdAt").descending());

    @DisplayName("작성 시간 최신순으로 게시물 가져오기.")
    @Test
    void findAll() {
        // given

        // when
        Page<Post> all = repo.findAll(page);

        // then
        all.get().map(Object::toString).forEach(log::trace);
        assertThat(all).isNotEmpty();
    }
    @DisplayName("제목에 해당 키워드가 포함된 게시물 가져오기.")
    @Test
    void findByTitleContaining() {
        // given
        String keyword = "New";

        // when
        Page<Post> all = repo.findByTitleContaining(keyword, page);

        // then
        all.get().map(Object::toString).forEach(log::trace);
        assertThat(all).isNotEmpty();
    }

    @DisplayName("작성자명에 해당 키워드가 포함된 게시물 가져오기.")
    @Test
    void findByUseraccount_IdContaining() {
        // given
        String keyword = "oo";

        // when
        Page<Post> all = repo.findByUseraccount_UsernameContaining(keyword, page);

        // then
        all.get().map(Object::toString).forEach(log::trace);
        assertThat(all).isNotEmpty();
    }

    @DisplayName("내용에 해당 키워드가 포함된 게시물 가져오기.")
    @Test
    void findByContentContaining() {
        // given
        String keyword = "ante";

        // when
        Page<Post> all = repo.findByContentContaining(keyword, page);

        // then
        all.get().map(Object::toString).forEach(log::trace);
        assertThat(all).isNotEmpty();
    }

    @DisplayName("해시코드에 해당 키워드가 포함된 게시물 가져오기.")
    @Test
    void findByHashtagContaining() {
        // given
        String keyword = "Romance";

        // when
        Page<Post> all = repo.findByHashtagContaining(keyword, page);

        // then
        all.get().map(Object::toString).forEach(log::trace);
        assertThat(all).isNotEmpty();
    }
}