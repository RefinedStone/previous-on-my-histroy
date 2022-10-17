package com.sparta.jwt_submit_try4.repository;



import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
    Optional<Comment> findById(String Id);
}