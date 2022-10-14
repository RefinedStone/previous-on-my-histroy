package com.sparta.jwt_submit_try4.controller;


import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import com.sparta.jwt_submit_try4.entity.Comment;
import com.sparta.jwt_submit_try4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;
    //모든 글 읽어 오기
    /*@GetMapping("/dev/comment")
    public List<Comment> getAllpost(){return commentService.getAllpost();}*/

    //댓글 쓰기
    @PostMapping("/dev/comment/{id}")
    // 사용자가 댓글을 저장하면
    // front에서 게시글의 id와 댓글의 내용을 같이 보내줍니다. (postman, ARC)
    // backend 에서는 @RequestBody annotation과 requestDto를 이용하여 front가 보내준 정보를 전달받습니다.
    // 부족한점: 일단 entity 외부의 노출되지 않아야 합니다.
    // return 할 때는 dto에 다시 정보를 전달해서 return을 합니다.
    // responseDto를 새로 만들어서 보여줄 내용만 return합니다. (정석)
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = commentService.createComment(requestDto);
        return comment;
        // 위 아래가 동일한 코드입니다.
        //return commentService.createComment(requestDto);
    }

    // passwordEncoder라는 것을 비밀번호를 encoding 해줍니다.

    /*//댓글 수정
    @PutMapping("/dev/comment/{id}")
    public Optional<Comment> updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id){
        return commentService.updateComment(requestDto, id);}


    //댓글 삭제
    @DeleteMapping("/dev/comment/{id}")
    public void deleteComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long id) {
        commentService.deleteComment(requestDto,id);
    }*/
}
