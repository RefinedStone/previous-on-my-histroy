package com.sparta.submitHomwork.controller;

import com.sparta.submitHomwork.domain.Post;
import com.sparta.submitHomwork.dto.PostRequestDto;
import com.sparta.submitHomwork.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
//    @Autowired
//    public PostController(PostService postService) {this.postService = postService;}

    //모든 글 읽어 오기
    @GetMapping("/memo")
    public List<Post> getAllpost(){return postService.getAllpost();}

    //글 쓰기
    @PostMapping("/memo")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @PutMapping("/memo/{id}")
    public Post updatePost(@RequestBody PostRequestDto requestDto, Long id){
        return postService.updatePost(requestDto);
    }

}
