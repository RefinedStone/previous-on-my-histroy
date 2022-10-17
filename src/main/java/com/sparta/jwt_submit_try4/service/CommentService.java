package com.sparta.jwt_submit_try4.service;

import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
//    public List<Comment> getAllcomment() {
//    }

    public Comment createComment(CommentRequestDto requestDto,Long id) {

        Comment comment = new Comment(requestDto,id);
        return comment;

    }

//    public Optional<Post> updateComment(CommentRequestDto requestDto, Long id) {
//    }

//    public void deleteComment(CommentRequestDto requestDto, Long id) {
//    }
}
