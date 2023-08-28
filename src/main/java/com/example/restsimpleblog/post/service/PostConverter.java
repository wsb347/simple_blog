package com.example.restsimpleblog.post.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.model.BoardDto;
import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.model.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostConverter {

    public PostDto toDto (PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getBoard().getId())
                .email(postEntity.getEmail())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .password(postEntity.getPassword())
                .status(postEntity.getStatus())
                .date(postEntity.getDate())
                .userName(postEntity.getUserName())
                .build();
    }


}
