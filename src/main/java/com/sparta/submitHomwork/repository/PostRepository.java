package com.sparta.submitHomwork.repository;

import com.sparta.submitHomwork.domain.Post;
import com.sparta.submitHomwork.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long Id);
    List<Post> findAllByOrderByModifiedAtDesc();

    List<Post> findAllByOrderByCreatedTimeDesc();
}
