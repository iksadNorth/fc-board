package me.iksadnorth.board.controller;

import me.iksadnorth.board.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("api test - api/posts/~")
@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    @DisplayName("/api/posts/ - 게시글 리스트 조회")
    @Test
    public void givenNothing_whenRequestingPosts_thenReturnsPosts() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/posts/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/:id - 게시글 단일 조회 - issue#18 1-1-2 참고")
    @Test
    public void givenPostId_whenRequestingPost_thenReturnsPost() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/:id?page=:page&size=:size - 게시글 단일 조회 - issue#18 1-1-3 참고")
    @Test
    public void givenPostIdWithPage_whenRequestingPost_thenReturnsPost() throws Exception {
        // given

        // when & then
        mvc.perform(get("/api/posts/1?page=1&size=5"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/ - 게시글 추가 - issue#18 1-1-5 참고")
    @Test
    public void givenPostInfo_whenSavingPost_thenSavesPost() throws Exception {
        // given

        // when & then
        mvc.perform(post("/api/posts/")
                        .param("title", "첫 게시물")
                        .param("content", "첫 게시물입니다.")
                        .param("hashtag", "기대"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/:id - 게시글 수정 - issue#18 1-2-1 참고")
    @Test
    public void givenPostInfo_whenUpdatingPost_thenUpdatesPost() throws Exception {
        // given

        // when & then
        mvc.perform(put("/api/posts/1")
                        .param("title", "첫 게시물 수정")
                        .param("content", "첫 게시물 수정입니다.")
                        .param("hashtag", "기대 수정"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/:id - 게시글 삭제 - issue#18 1-2-1 참고")
    @Test
    public void givenPostId_whenDeletingPost_thenDeletesPost() throws Exception {
        // given

        // when & then
        mvc.perform(delete("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}