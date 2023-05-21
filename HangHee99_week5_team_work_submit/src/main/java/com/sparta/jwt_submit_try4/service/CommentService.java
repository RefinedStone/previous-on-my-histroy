package com.sparta.jwt_submit_try4.service;
import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import com.sparta.jwt_submit_try4.controller.dto.CommentResponseDto;
import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import com.sparta.jwt_submit_try4.jwt.entity.Member;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import com.sparta.jwt_submit_try4.repository.CommentRepository;
import com.sparta.jwt_submit_try4.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberService memberService;

    public CommentResponseDto<?> createCommentWithManyToOne(CommentRequestDto requestDto) {
        Post post = new Post();
        post = postRepository.findById(requestDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다.")
        );
        Comment comment = new Comment(requestDto, post);
        return CommentResponseDto.success(commentRepository.save(comment));
    }
    public CommentResponseDto<?> updateComment(CommentRequestDto requestDto, Long id) {
        // 현재 작성자 member
        Member member = memberService.getInfo();
        // 수정하려는 포스트
        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("게시글을 찾을 수 없습니다")
        );
        //수정하려는 포스트 멤버 = 현재 작성자?
        if (!post.getMember().equals(member)) {
            throw new IllegalArgumentException("작성자가 불일치");
        }
        //커멘트 수정
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다")
        );
        comment.update(requestDto);
        return CommentResponseDto.success(comment);
    }

}


