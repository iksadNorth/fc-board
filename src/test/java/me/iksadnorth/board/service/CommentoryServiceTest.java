package me.iksadnorth.board.service;

import lombok.extern.slf4j.Slf4j;
import me.iksadnorth.board.domain.Commentory;
import me.iksadnorth.board.dto.CommentoryDto;
import me.iksadnorth.board.repository.CommentoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@Slf4j
@DisplayName("댓글 서비스 테스트")
@Transactional
@ExtendWith(MockitoExtension.class)
class CommentoryServiceTest {
    @InjectMocks
    private CommentoryService commentoryService;
    
    @Mock
    private CommentoryRepository commentoryRepository;

    @DisplayName("댓글 추가 - issue#18 1-2-3 참고")
    @Test
    public void giveCommentInfo_whenSavingComment_thenSavesComment() {
        // give
        CommentoryDto commentoryDto = CommentoryDto.of(
                "첫 댓글 내용."
        );

        // when
        commentoryService.saveCommentory(commentoryDto);

        // then
        then(commentoryRepository).should().save(any(Commentory.class));

    }

    @DisplayName("댓글 수정 - issue#18 1-2-4 참고")
    @Test
    public void giveCommentInfo_whenUpdatingComment_thenUpdatesComment() {
        // give
        CommentoryDto commentoryDto = CommentoryDto.of(
                1L, "첫 댓글 내용 수정."
        );
        given(commentoryRepository.getReferenceById(any())).willReturn(new Commentory());

        // when
        commentoryService.updateCommentory(commentoryDto.getId(), commentoryDto);

        // then
        then(commentoryRepository).should().save(any(Commentory.class));

    }

    @DisplayName("댓글 삭제 - issue#18 1-2-5 참고")
    @Test
    public void giveCommentId_whenDeletingComment_thenDeletesComment() {
        // give

        // when
        commentoryService.deleteCommentory(1L);

        // then
        then(commentoryRepository).should().deleteById(any(Long.class));

    }

    @DisplayName("댓글 조회 with 페이징, 정렬 - issue#18 1-2-6 참고")
    @Test
    public void giveParams_whenLoadingComments_thenLoadsComments() {
        // give
        Pageable page = PageRequest.of(1, 5, Sort.by("created_at").descending());
        given(commentoryRepository.findByPost_Id(anyLong(), any(PageRequest.class))).willReturn(Page.empty());

        // when
        Page<CommentoryDto> commentories = commentoryService.loadCommentory(0L, page);
        log.trace(Optional.ofNullable(commentories).toString());
        log.trace(Page.empty().toString());

        // then
        assertThat(commentories).isNotNull();

    }
}