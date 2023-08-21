package com.example.restsimpleblog.board.controller;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.model.BoardRequest;
import com.example.restsimpleblog.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(@Valid @RequestBody BoardRequest boardRequest){
            return boardService.create(boardRequest);
    }
}
