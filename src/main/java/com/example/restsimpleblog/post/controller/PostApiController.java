package com.example.restsimpleblog.post.controller;

import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.model.PostRequest;
import com.example.restsimpleblog.post.model.ViewPostRequest;
import com.example.restsimpleblog.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(@Valid @RequestBody PostRequest postRequest) {
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostEntity view(@Valid @RequestBody ViewPostRequest viewPostRequest) {

        return postService.findById(viewPostRequest);
    }

    @GetMapping()
    public List<PostEntity> list() {

        return postService.allList();
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ViewPostRequest viewPostRequest) {

        postService.delete(viewPostRequest);
    }

}
