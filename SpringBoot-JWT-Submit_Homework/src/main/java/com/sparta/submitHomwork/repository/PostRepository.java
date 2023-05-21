package com.sparta.submitHomwork.repository;

import com.sparta.submitHomwork.domain.Post;
import com.sparta.submitHomwork.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
   // Optional<Post> findById(Long Id);
  //  List<Post> findAllByOrderByModifiedAtDesc();

    List<Post> findAllByOrderByCreatedAtDesc();
}
