package com.sparta.jwt_submit_try4.controller;


import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import com.sparta.jwt_submit_try4.jwt.entity.Comment;
import com.sparta.jwt_submit_try4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    //모든 글 읽어 오기
//    @GetMapping("/dev/comment")
//    public List<Comment> getAllpost(){return commentService.getAllpost();}

    //댓글 쓰기
    @PostMapping("/dev/comment/{id}")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long post_id){
        return commentService.createComment(requestDto,post_id);
    }

//댓글 수정
//    @PutMapping("/dev/comment/{id}")
//    public Optional<Comment> updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id){
//        return commentService.updateComment(requestDto, id);}
//
//
//    //댓글 삭제
//    @DeleteMapping("/dev/comment/{id}")
//    public void deleteComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id) {
//        commentService.deleteComment(requestDto,id);
//    }
}
