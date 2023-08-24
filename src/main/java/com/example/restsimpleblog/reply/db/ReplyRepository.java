package com.example.restsimpleblog.reply.db;

import com.example.restsimpleblog.post.db.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {


}
