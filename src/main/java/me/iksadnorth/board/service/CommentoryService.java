package me.iksadnorth.board.service;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.dto.CommentoryDto;
import me.iksadnorth.board.repository.CommentoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentoryService {

    private final CommentoryRepository commentoryRepository;

    public static void saveCommentory(CommentoryDto commentoryDto) {
    }

    public static void updateCommentory(CommentoryDto commentoryUpdateDto) {
    }

    public static void deleteCommentory(long id) {
    }

    public static Page<CommentoryDto> loadCommentory(Pageable page) {
        return null;
    }
}
