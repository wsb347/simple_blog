package com.example.restsimpleblog.board.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.model.BoardDto;
import com.example.restsimpleblog.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto (BoardEntity boardEntity){
        var postList = boardEntity.getPostlist().stream()
                .map(postEntity -> {
                    return postConverter.toDto(postEntity);
                }).collect(Collectors.toList());

        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .postList(postList)
                .status(boardEntity.getStatus())
                .build();

    }
}
