package me.iksadnorth.board.service;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.dto.PostDto;
import me.iksadnorth.board.repository.PostRepository;
import me.iksadnorth.board.type.SearchType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<PostDto> searchPosts(SearchType searchType, String keyword, Pageable pageable) {
        return null;
    }

    public void savePost(PostDto postDto) {
//        postRepository.save(postDto);
    }

    public void updatePost(PostDto postUpdateDto) {
    }

    public void deletePost(long id) {
    }
}
