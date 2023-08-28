package com.example.restsimpleblog.post.service;

import com.example.restsimpleblog.board.db.BoardRepository;
import com.example.restsimpleblog.board.model.BoardDto;
import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.db.PostRepository;
import com.example.restsimpleblog.post.model.PostDto;
import com.example.restsimpleblog.post.model.PostRequest;
import com.example.restsimpleblog.post.model.ViewPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final PostConverter postConverter;

    public PostDto create(PostRequest postRequest){

        var boardEntity = boardRepository.findById(postRequest.getBoardId());

        if(boardEntity.isEmpty()){
            throw new RuntimeException("게시물이 없습니다. : " + postRequest.getBoardId());
        }

        PostEntity postEntity = PostEntity.builder()
                .board(boardEntity.get())
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .date(LocalDateTime.now())
                .build();

        var post = postRepository.save(postEntity);


    return postConverter.toDto(post);

    }


    public PostDto findById(ViewPostRequest viewPostRequest) {

        var post = postRepository.findFirstByIdAndStatusOrderByIdDesc(viewPostRequest.getPostId(), "REGISTERED")
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
        return postConverter.toDto(post);
    }

    public List<PostEntity> allList() {
         return postRepository.findAllByOrderByIdDesc();
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


    public PostDto updatePost(Long id, PostDto updatedPost) {
        PostEntity postEntity = postRepository.findById(id)
                .map( it -> {
                    if(!it.getPassword().equals(updatedPost.getPassword())){
                        String format = "잘못된 패스워드 입니다 %s : %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), updatedPost.getPassword()));
                    }
                    postRepository.save(it);
                    return it;
                })
                .orElseThrow(
                        () -> {
                            return new RuntimeException("게시물이 없습니다.");
                        }
                );

        if (updatedPost.getTitle() != null) {
            postEntity.setTitle(updatedPost.getTitle());
        }
        if (updatedPost.getContent() != null) {
            postEntity.setContent(updatedPost.getContent());
        }
         var post = postRepository.save(postEntity);

        return postConverter.toDto(post);
    }
}
