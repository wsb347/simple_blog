package com.example.restsimpleblog.board.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.db.BoardRepository;
import com.example.restsimpleblog.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardEntity create( BoardRequest boardRequest){

        BoardEntity boardEntity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        return boardRepository.save(boardEntity);
    }

}
