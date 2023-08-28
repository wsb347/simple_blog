package com.example.restsimpleblog.post.db;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.post.model.PostDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OrderBy;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    @OrderBy(clause = "id desc")
    private BoardEntity board;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime date;


    public PostEntity toUpdateEntity(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());

        return postEntity;
    }
}
