package com.sparta.jwt_submit_try4.service;

import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;

import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import com.sparta.jwt_submit_try4.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment createComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }
}


