package me.iksadnorth.board.controller;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.dto.CommentoryDto;
import me.iksadnorth.board.service.CommentoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/posts/{postId}/comments")
@RestController
public class CommentoryController {

    private final CommentoryService commentoryService;

    @PostMapping("/")
    public void saveComment(@PathVariable Long postId, @RequestBody CommentoryDto dto) {
        dto = dto.with(postId);
        commentoryService.saveCommentory(dto);
    }

    @PutMapping("/{commentId}")
    public void updateComment(@PathVariable Long postId,
                              @PathVariable Long commentId,
                              @RequestBody CommentoryDto dto) {
        dto = dto.with(postId);
        commentoryService.updateCommentory(commentId, dto);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentoryService.deleteCommentory(commentId);
    }

    @GetMapping("/")
    public Page<CommentoryDto> searchComment(@PathVariable Long postId,
                                             @PageableDefault(
                                      size = 10, page = 0, direction = Sort.Direction.DESC, sort = "createdAt"
                              ) Pageable pageable) {
        return commentoryService.loadCommentory(postId, pageable);
    }
}
