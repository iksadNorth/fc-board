package me.iksadnorth.board.controller;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostController {

    private final PostService postService;

}
