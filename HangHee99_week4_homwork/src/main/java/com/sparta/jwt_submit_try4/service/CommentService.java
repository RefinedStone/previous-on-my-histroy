package com.sparta.jwt_submit_try4.service;

import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import com.sparta.jwt_submit_try4.entity.Comment;
import com.sparta.jwt_submit_try4.entity.Post;
import com.sparta.jwt_submit_try4.repository.CommentRepository;
import com.sparta.jwt_submit_try4.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    /*public List<Comment> getAllcomment() {
    }*/

    public Comment createComment(CommentRequestDto requestDto) {
        // 상황: 사용자가 게시글 a에 댓글 b를 달아놓은 상태에요
        // a라는 게시글을 들고옵니다.
        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다.")
        );

        // comment라는 entity를 생성할거야
        // requestDto, post라는 정보를 같이 넣어줄 테니까, 이것을 이용해서 comment를 생성해줘
        Comment comment = new Comment(requestDto, post);

        Comment savedComment = commentRepository.save(comment);
        return savedComment;
    }

    public void postingTest(CommentRequestDto requestDto, Long Id){

        postRepository.findById(Id);
    }
    /*public Optional<Post> updateComment(CommentRequestDto requestDto, Long id) {
    }

    public void deleteComment(CommentRequestDto requestDto, Long id) {
    }*/
}
