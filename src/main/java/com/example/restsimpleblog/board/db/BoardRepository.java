package com.example.restsimpleblog.board.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  BoardRepository extends  JpaRepository<BoardEntity, Long> {
}
