package me.iksadnorth.board.service;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.domain.Post;
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
        if (keyword == null || keyword.isBlank()) {
            postRepository.findAll(pageable).map(PostDto::from);
        }

        return switch (searchType) {
            case TITLE -> postRepository.findByTitleContaining(keyword, pageable).map(PostDto::from);
            case USERNAME -> postRepository.findByUseraccount_UsernameContaining(keyword, pageable).map(PostDto::from);
            case CONTENT -> postRepository.findByContentContaining(keyword, pageable).map(PostDto::from);
            case HASHTAG -> postRepository.findByHashtagContaining(keyword, pageable).map(PostDto::from);
        };
    }

    public void savePost(PostDto postDto) {
        postRepository.save(PostDto.toEntity(postDto));
    }

    public void updatePost(Long id, PostDto postDto) {
        Post post = postRepository.getReferenceById(id);

        if (postDto.getTitle() != null) {post.setTitle(postDto.getTitle());}
        if (postDto.getContent() != null) {post.setContent(postDto.getContent());}
        post.setHashtag(postDto.getHashtag());

        postRepository.save(post);
    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public PostDto loadPost(Long id) {
        return PostDto.from(postRepository.findById(id).get());
    }
}
