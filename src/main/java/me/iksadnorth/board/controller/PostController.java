package me.iksadnorth.board.controller;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.dto.PostDto;
import me.iksadnorth.board.service.PostService;
import me.iksadnorth.board.type.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public Page<PostDto> searchPosts(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String keyword,
            @PageableDefault(page = 1, size = 10, sort = {"creat_at"}, direction = Sort.Direction.DESC) Pageable page
            ) {
        return postService.searchPosts(searchType, keyword, page);
    }

    @GetMapping("/{id}")
    public PostDto loadPost(
            @PathVariable Long id
    ) {
        return postService.loadPost(id);
    }

    @PostMapping("/")
    public void appendPost(
            @RequestBody PostDto dto
    ) {
        postService.savePost(dto);
    }

    @PutMapping("/{id}")
    public void updatePost(
            @PathVariable Long id,
            @RequestBody PostDto dto
    ) {
        postService.updatePost(id, dto);
    }

    @DeleteMapping("/{id}")
    public void updatePost(
            @PathVariable Long id
    ) {
        postService.deletePost(id);
    }

}
