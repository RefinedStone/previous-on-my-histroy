package com.sparta.jwt_submit_try4.service;


import com.sparta.jwt_submit_try4.controller.dto.PostRequestDto;
import com.sparta.jwt_submit_try4.controller.dto.PostResponseDto;
import com.sparta.jwt_submit_try4.jwt.entity.Member;
import com.sparta.jwt_submit_try4.jwt.entity.Post;
import com.sparta.jwt_submit_try4.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberService memberService;


    @Autowired
    public PostService(PostRepository postRepository, MemberService memberService) {
        this.postRepository = postRepository;
        this.memberService = memberService;
    }


    // 모든 글 읽어오기
    public List<Post> getAllpost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    //글 쓰기
    public PostResponseDto<?> createPost(PostRequestDto requestDto) {
        Member member = memberService.getInfo();
        Post post = new Post(requestDto,member);
        postRepository.save(post);
        return PostResponseDto.success(post);
    }

    @Transactional
    public Optional<Post> updatePost(PostRequestDto requestDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        post.update(requestDto);
        return postRepository.findById(id);

    }

    public void deletePost(PostRequestDto requestDto, Long id) {
        postRepository.deleteById(id);
    }


}

