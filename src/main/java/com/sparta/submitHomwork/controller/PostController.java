package com.sparta.submitHomwork.controller;


import com.sparta.submitHomwork.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//@AllArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {this.postService = postService;}

    //모든 글 읽어 오기
    @GetMapping("/post")
    public void getAllpost(){postService.getAllpost();}




}
