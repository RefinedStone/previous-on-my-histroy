package com.sparta.jwt_submit_try4.controller;


import com.sparta.jwt_submit_try4.controller.dto.*;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import com.sparta.jwt_submit_try4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/dev")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    //모든 글 읽어 오기
    @GetMapping("/auth/post")
    public ResponseEntity<PostResponseDto<?>> getAllpost(){
        return ResponseEntity.ok(postService.getAllpost());
    }
    //글 쓰기
    @PostMapping("/post")
    public ResponseEntity<PostResponseDto<?>> signup(@RequestBody PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }
    //글 수정
    @PutMapping("/post/{id}")
    public ResponseEntity<PostResponseDto<?>> updatePost(@RequestBody PostRequestDto requestDto, @PathVariable Long id){
        return ResponseEntity.ok(postService.updatePost(requestDto, id));
    }


    //글 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<PostResponseDto<String>> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

}
