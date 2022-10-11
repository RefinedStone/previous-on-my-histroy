package com.sparta.submitHomwork.controller;

import com.sparta.submitHomwork.domain.Post;
import com.sparta.submitHomwork.dto.PostRequestDto;
import com.sparta.submitHomwork.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
//    @Autowired
//    public PostController(PostService postService) {this.postService = postService;}

    //모든 글 읽어 오기
    @GetMapping("/memos")
    public void getAllpost(){postService.getAllpost();}

    //글 쓰기
    @PostMapping("/memo")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }


}
