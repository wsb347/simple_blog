package com.example.restsimpleblog.board.controller;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.model.BoardDto;
import com.example.restsimpleblog.board.model.BoardRequest;
import com.example.restsimpleblog.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardAPIController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(@Valid @RequestBody BoardRequest boardRequest){
            return boardService.create(boardRequest);
    }

    @GetMapping("/{id}")
    public BoardDto list(@Valid @PathVariable Long id){
        return boardService.findById(id);
    }
}
