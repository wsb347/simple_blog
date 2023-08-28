package com.example.restsimpleblog.board.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.db.BoardRepository;
import com.example.restsimpleblog.board.model.BoardDto;
import com.example.restsimpleblog.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(BoardRequest boardRequest){

        BoardEntity boardEntity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var board = boardRepository.save(boardEntity);

        return boardConverter.toDto(board);
    }

    public BoardDto findById(Long id) {
        var board = boardRepository.findById(id)
                .map( it -> {
                     return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("게시물이 없습니다.");
                        }
                );

        return boardConverter.toDto(board);
    }
}
