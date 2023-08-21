package com.example.restsimpleblog.post.controller;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.model.BoardRequest;
import com.example.restsimpleblog.board.service.BoardService;
import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.model.PostRequest;
import com.example.restsimpleblog.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(@Valid @RequestBody PostRequest postRequest){
        return postService.create(postRequest);
    }

}
