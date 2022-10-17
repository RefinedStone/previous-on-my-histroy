package com.sparta.jwt_submit_try4.service;

import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;

import com.sparta.jwt_submit_try4.controller.dto.CommentResponseDto;
import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import com.sparta.jwt_submit_try4.repository.CommentRepository;
import com.sparta.jwt_submit_try4.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


//    public Comment createComment(CommentRequestDto requestDto) {
//        Comment comment = new Comment(requestDto);
//        return commentRepository.save(comment);
//    }
    public CommentResponseDto<?> createCommentWithManyToOne(CommentRequestDto requestDto){
        Post post = new Post();
        post = postRepository.findById(requestDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다.")
        );
        Comment comment = new Comment(requestDto,post);
        return CommentResponseDto.success(commentRepository.save(comment));

    }

//    public CommentResponseDto<?> updateComment(CommentRequestDto requestDto, Long id) {
////        Post post = new Post();
////        post = postRepository.findById(requestDto.getPostId()).orElseThrow(
////                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다")
////        );
////        Comment comment = new Comment(requestDto,post);
////       // comment = commentRepository.findById(id)
//    }
}


