package me.iksadnorth.board.controller;

import me.iksadnorth.board.config.TestSecurityConfig;
import me.iksadnorth.board.service.CommentoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static me.iksadnorth.board.utils.HttpBody.make;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("api test - api/posts/{postId}/comments/~")
@WithMockUser
@Import({TestSecurityConfig.class})
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
        Map<String, String> params = new HashMap<>();
        params.put("content", "첫 댓글 내용");

        // when & then
        mvc.perform(post("/api/posts/1/comments/")
                        .with(csrf())
                        .content(make(params))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

    }

    @DisplayName("댓글 수정 - issue#18 1-2-4 참고")
    @Test
    public void giveCommentInfo_whenUpdatingComment_thenUpdatesComment() throws Exception {
        // give
        Map<String, String> params = new HashMap<>();
        params.put("content", "첫 댓글 내용 수정");

        // when & then
        mvc.perform(put("/api/posts/1/comments/1")
                        .with(csrf())
                        .content(make(params))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @DisplayName("댓글 삭제 - issue#18 1-2-5 참고")
    @Test
    public void giveCommentId_whenDeletingComment_thenDeletesComment() throws Exception {
        // give

        // when & then
        mvc.perform(delete("/api/posts/1/comments/1")
                        .with(csrf()))
                .andExpect(status().isOk());

    }

    @DisplayName("댓글 조회 with 페이징, 정렬 - issue#18 1-2-6 참고")
    @Test
    public void giveCommentParams_whenLoadingComment_thenLoadsComment() throws Exception {
        // give
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("page", "1");
        params.add("size", "5");
        params.add("sort", "created_at,decs");

        // when & then
        mvc.perform(get("/api/posts/1/comments/")
                        .params(params))
                .andExpect(status().isOk());

    }

}