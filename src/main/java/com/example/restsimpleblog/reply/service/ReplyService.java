package com.example.restsimpleblog.reply.service;

import com.example.restsimpleblog.reply.db.ReplyEntity;
import com.example.restsimpleblog.reply.db.ReplyRepository;
import com.example.restsimpleblog.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService {

    public final ReplyRepository replyRepository;

    public ReplyEntity create(ReplyRequest replyRequest){
        var replyEntity = ReplyEntity.builder()
                .postId(replyRequest.getPostId())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .date(LocalDateTime.now())
                .build();

        return replyRepository.save(replyEntity);
    }


}
