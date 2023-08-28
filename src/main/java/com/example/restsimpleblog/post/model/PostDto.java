package com.example.restsimpleblog.post.model;

import com.example.restsimpleblog.board.db.BoardEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

    private Long id;

    private Long boardId;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    private String content;

    private LocalDateTime date;
}
