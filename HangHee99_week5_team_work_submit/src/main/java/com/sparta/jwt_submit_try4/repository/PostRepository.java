package com.sparta.jwt_submit_try4.repository;


import com.sparta.jwt_submit_try4.jwt.entity.Member;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
    Optional<Post> findById(String Id);

}
