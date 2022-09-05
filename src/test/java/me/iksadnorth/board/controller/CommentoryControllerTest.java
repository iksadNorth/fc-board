package me.iksadnorth.board.controller;

import me.iksadnorth.board.domain.Commentory;
import me.iksadnorth.board.repository.CommentoryRepository;
import me.iksadnorth.board.service.CommentoryService;
import me.iksadnorth.board.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("api test - api/comments/~")
@WebMvcTest(CommentoryController.class)
class CommentoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommentoryService commentoryService;

    @DisplayName("댓글 추가 - issue#18 1-2-3 참고")
    @Test
    public void giveCommentInfo_whenSavingComment_thenSavesComment() throws Exception {
        // give

        // when & then
        mvc.perform(post("/api/comments/")
                .param("content", "첫 댓글 내용"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @DisplayName("댓글 수정 - issue#18 1-2-4 참고")
    @Test
    public void giveCommentInfo_whenUpdatingComment_thenUpdatesComment() throws Exception {
        // give

        // when & then
        mvc.perform(put("/api/comments/1")
                        .param("content", "첫 댓글 내용 수정"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @DisplayName("댓글 삭제 - issue#18 1-2-5 참고")
    @Test
    public void giveCommentId_whenDeletingComment_thenDeletesComment() throws Exception {
        // give

        // when & then
        mvc.perform(put("/api/comments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @DisplayName("댓글 조회 with 페이징, 정렬 - issue#18 1-2-6 참고")
    @Test
    public void giveCommentParams_whenLoadingComment_thenLoadsComment() throws Exception {
        // give

        // when & then
        mvc.perform(put("/api/comments/")
                        .param("page", "1")
                        .param("size", "5")
                        .param("sort", "created_at,decs"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

}