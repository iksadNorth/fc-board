package me.iksadnorth.board.controller;

import lombok.RequiredArgsConstructor;
import me.iksadnorth.board.repository.CommentoryRepository;
import me.iksadnorth.board.service.CommentoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/comments")
@RestController
public class CommentoryController {

    private final CommentoryService commentoryService;

}
