package me.iksadnorth.board.service;

import me.iksadnorth.board.domain.Post;
import me.iksadnorth.board.dto.PostDto;
import me.iksadnorth.board.repository.PostRepository;
import me.iksadnorth.board.type.SearchType;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비지니스 로직 - 게시판")
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @DisplayName("게시글을 제목으로 검색하면, 게시글 리스트를 반환한다. - issue#18 1-1-1 참고")
    @Test
    void givenSearchWithTITLE_whenSearchingPosts_thenReturnsPostList() {
        // Given

        // When
        Page<PostDto> posts = postService.searchPosts(SearchType.TITLE, "keyword", Pageable.unpaged());

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("게시글을 내용으로 검색하면, 게시글 리스트를 반환한다. - issue#18 1-1-1 참고")
    @Test
    void givenSearchWithCONTENT_whenSearchingPosts_thenReturnsPostList() {
        // Given

        // When
        Page<PostDto> posts = postService.searchPosts(SearchType.CONTENT, "keyword", Pageable.unpaged());

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("게시글을 id으로 검색하면, 게시글 리스트를 반환한다. - issue#18 1-1-1 참고")
    @Test
    void givenSearchWithID_whenSearchingPosts_thenReturnsPostList() {
        // Given

        // When
        Page<PostDto> posts = postService.searchPosts(SearchType.ID, "keyword", Pageable.unpaged());

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("게시글을 nickname으로 검색하면, 게시글 리스트를 반환한다. - issue#18 1-1-1 참고")
    @Test
    void givenSearchWithNICKNAME_whenSearchingPosts_thenReturnsPostList() {
        // Given

        // When
        Page<PostDto> posts = postService.searchPosts(SearchType.NICKNAME, "keyword", Pageable.unpaged());

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("게시글을 hashtag으로 검색하면, 게시글 리스트를 반환한다. - issue#18 1-1-1 참고")
    @Test
    void givenSearchWithHASHTAG_whenSearchingPosts_thenReturnsPostList() {
        // Given

        // When
        Page<PostDto> posts = postService.searchPosts(SearchType.HASHTAG, "keyword", Pageable.unpaged());

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("페이징 및 정렬 기능 구현 테스트. - issue#18 1-1-3,4 참고")
    @Test
    void givenNumOfPage_whenLoadPage_thenShowPageExpected() {
        // Given
        Pageable page = PageRequest.of(1, 5, Sort.by("created_at").descending());

        // When
        Page<PostDto> posts = postService.searchPosts(
                SearchType.TITLE,
                "keyword",
                page
        );

        // Then
        assertThat(posts).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다. - issue#18 1-1-5 참고")
    @Test
    void givenPostInfo_whenSavingPost_thenSavesPost() {
        // Given
        given(postRepository.save(any(Post.class))).willReturn(null);

        // When
        postService.savePost(
                PostDto.of("첫 게시물", "첫 게시글 내용", "설렘")
        );

        // Then
         then(postRepository).should().save(any(Post.class));
    }

    @DisplayName("게시글 내용을 수정 구현 테스트. - issue#18 1-2-1 참고")
    @Test
    void givenPostInfo_whenUpdatingPost_thenUpdatesPost() {
        // Given
        given(postRepository.save(any(Post.class))).willReturn(null);

        // When
        postService.updatePost(
                PostDto.of(1L, "첫 게시물", "첫 게시글 내용", "설렘")
        );

        // Then
        then(postRepository).should().save(any(Post.class));
    }

    @DisplayName("게시글 삭제 테스트. - issue#18 1-2-2 참고")
    @Test
    void givenNothing_whenDeletingPost_thenDeletesPost() {
        // Given

        // When
        postService.deletePost(1L);

        // Then
        then(postRepository).should().deleteById(any(Long.class));
    }

}