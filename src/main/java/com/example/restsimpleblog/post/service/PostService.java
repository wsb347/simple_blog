package com.example.restsimpleblog.post.service;

import com.example.restsimpleblog.board.db.BoardEntity;
import com.example.restsimpleblog.board.db.BoardRepository;
import com.example.restsimpleblog.board.model.BoardRequest;
import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.db.PostRepository;
import com.example.restsimpleblog.post.model.PostRequest;
import com.example.restsimpleblog.post.model.ViewPostRequest;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostEntity create(PostRequest postRequest){

        PostEntity postEntity = PostEntity.builder()
                .boardId(5L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .date(LocalDateTime.now())
                .build();

        return postRepository.save(postEntity);
    }


    public PostEntity findById(ViewPostRequest viewPostRequest) {

        return postRepository.findFirstByIdAndStatusOrderByIdDesc(viewPostRequest.getPostId(), "REGISTERED")
                .map( it -> {
                    if(!it.getPassword().equals(viewPostRequest.getPassword())){
                        String format = "잘못된 패스워드 입니다 %s : %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), viewPostRequest.getPassword()));
                    } return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("게시물이 없습니다.");
                        }
                );

    }

    public List<PostEntity> allList() {

        return postRepository.findAll();
    }

    public void delete(ViewPostRequest viewPostRequest) {

        postRepository.findById(viewPostRequest.getPostId())
                .map( it -> {
                    if(!it.getPassword().equals(viewPostRequest.getPassword())){
                        String format = "잘못된 패스워드 입니다 %s : %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), viewPostRequest.getPassword()));
                    } it.setStatus("UNREGSTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("게시물이 없습니다.");
                        }
                );

    }
}
