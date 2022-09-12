package me.iksadnorth.board.service;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.domain.Commentory;
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

    @Transactional(readOnly = true)
    public void saveCommentory(CommentoryDto commentoryDto) {
        commentoryRepository.save(commentoryDto.toEntity());
    }

    public void updateCommentory(Long id, CommentoryDto dto) {
        Commentory entity = commentoryRepository.getReferenceById(id);

        if (dto.getContent() != null) {entity.setContent(dto.getContent());}

        commentoryRepository.save(entity);
    }

    public void deleteCommentory(Long id) {
        commentoryRepository.deleteById(id);
    }

    public Page<CommentoryDto> loadCommentory(Long postId, Pageable page) {
        Page<Commentory> entity = commentoryRepository.findByPost_Id(postId, page);
        return entity.map(CommentoryDto::from);
    }
}
