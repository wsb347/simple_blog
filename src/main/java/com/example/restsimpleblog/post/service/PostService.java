package com.example.restsimpleblog.post.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.db.BoardRepository;
import com.example.restsimpleblog.board.model.BoardRequest;
import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.db.PostRepository;
import com.example.restsimpleblog.post.model.PostRequest;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostEntity create(PostRequest postRequest){

        PostEntity postEntity = PostEntity.builder()
                .boardId(5L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .date(LocalDateTime.now())
                .build();

        return postRepository.save(postEntity);
    }


}
