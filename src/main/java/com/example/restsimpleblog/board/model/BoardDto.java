package com.example.restsimpleblog.board.model;

import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.model.PostDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OrderBy;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardDto {

    private Long id;

    private String boardName;

    private String status;

     private List<PostDto> postList = List.of();

}
