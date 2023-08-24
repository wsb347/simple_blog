package com.example.restsimpleblog.reply.controlller;

import com.example.restsimpleblog.post.db.PostEntity;
import com.example.restsimpleblog.post.model.PostRequest;
import com.example.restsimpleblog.reply.db.ReplyEntity;
import com.example.restsimpleblog.reply.model.ReplyRequest;
import com.example.restsimpleblog.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyAPIController {

    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create(@Valid @RequestBody ReplyRequest replyRequest) {
        return replyService.create(replyRequest);
    }

}
