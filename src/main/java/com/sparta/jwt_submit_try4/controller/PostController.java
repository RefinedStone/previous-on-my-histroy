package com.sparta.jwt_submit_try4.controller;


import com.sparta.jwt_submit_try4.controller.dto.PostRequestDto;
import com.sparta.jwt_submit_try4.entity.Post;
import com.sparta.jwt_submit_try4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/dev")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
//    @Autowired
//    public PostController(PostService postService) {this.postService = postService;}

    //모든 글 읽어 오기
    @GetMapping("/auth/post")
    public List<Post> getAllpost(){return postService.getAllpost();}

    //글 쓰기
    @PostMapping("/post")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    //글 수정
    @PutMapping("/post/{id}")
    public Optional<Post> updatePost(@RequestBody PostRequestDto requestDto, @PathVariable Long id){
        return postService.updatePost(requestDto, id);}


    //글 삭제
    @DeleteMapping("/post/{id}")
    public void deletePost(@RequestBody PostRequestDto requestDto, @PathVariable Long id) {
        postService.deletePost(requestDto,id);
    }

}
