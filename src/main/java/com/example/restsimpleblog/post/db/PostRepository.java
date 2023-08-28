package com.example.restsimpleblog.post.db;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface  PostRepository extends JpaRepository<PostEntity, Long> {

    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long postId, String status);

    public List<PostEntity> findAllByOrderByIdDesc();

}
