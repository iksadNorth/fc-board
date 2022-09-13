package me.iksadnorth.board.controller;

import me.iksadnorth.board.dto.PostDto;
import me.iksadnorth.board.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static me.iksadnorth.board.utils.HttpBody.make;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("api test - api/posts/~")
@WithMockUser
@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private final PostDto postDto = PostDto.of("test title", "test content", "test hashtag");

    @DisplayName("/api/posts/ - 게시글 리스트 조회")
    @Test
    public void givenNothing_whenRequestingPosts_thenReturnsPosts() throws Exception {
        // given
        given(postService.searchPosts(any(), any(), any(Pageable.class))).willReturn(Page.empty());

        // when & then
        mvc.perform(get("/api/posts/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/:id - 게시글 단일 조회 - issue#18 1-1-2 참고")
    @Test
    public void givenPostId_whenRequestingPost_thenReturnsPost() throws Exception {
        // given
        given(postService.loadPost(any(Long.class))).willReturn(this.postDto);

        // when & then
        mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/?page=:page&size=:size - 해당 페이지의 게시글 리스트 조회 - issue#18 1-1-3 참고")
    @Test
    public void givenPostIdWithPage_whenRequestingPost_thenReturnsPost() throws Exception {
        // given
        given(postService.searchPosts(any(), any(), any(Pageable.class))).willReturn(Page.empty());


        // when & then
        mvc.perform(get("/api/posts/?page=1&size=5"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @DisplayName("/api/posts/ - 게시글 추가 - issue#18 1-1-5 참고")
    @Test
    public void givenPostInfo_whenSavingPost_thenSavesPost() throws Exception {
        // given
        Map<String, String> params = new HashMap<>();
        params.put("title", "첫 게시물");
        params.put("content", "첫 게시물입니다.");
        params.put("hashtag", "기대");

        // when & then
        mvc.perform(post("/api/posts/")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(make(params)))
                        .andExpect(status().isOk());
    }

    @DisplayName("/api/posts/:id - 게시글 수정 - issue#18 1-2-1 참고")
    @Test
    public void givenPostInfo_whenUpdatingPost_thenUpdatesPost() throws Exception {
        // given
        Map<String, String> params = new HashMap<>();
        params.put("title", "첫 게시물 수정");
        params.put("content", "첫 게시물 수정입니다.");
        params.put("hashtag", "기대 수정");

        // when & then
        mvc.perform(put("/api/posts/1")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(make(params)))
                .andExpect(status().isOk());
    }

    @DisplayName("/api/posts/:id - 게시글 삭제 - issue#18 1-2-1 참고")
    @Test
    public void givenPostId_whenDeletingPost_thenDeletesPost() throws Exception {
        // given

        // when & then
        mvc.perform(delete("/api/posts/1")
                        .with(csrf()))
                .andExpect(status().isOk());
    }
}