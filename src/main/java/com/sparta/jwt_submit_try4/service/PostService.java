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
    public PostResponseDto<?> getAllpost() {
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        return PostResponseDto.success(postList);
    }

    //글 쓰기
    public PostResponseDto<?> createPost(PostRequestDto requestDto) {
        Member member = memberService.getInfo();
        Post post = new Post(requestDto, member);
        postRepository.save(post);
        return PostResponseDto.success(post);
    }

    //글 수정
    @Transactional
    public PostResponseDto<?> updatePost(PostRequestDto requestDto, Long id) {
      //수정 요청한사람
        Member member = memberService.getInfo();
        //수정한 글 찾아오기
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        //게시글 작성자
        Member member2 = post.getMember();
        if(!member.getId().equals(member2.getId())){
            throw new IllegalArgumentException("id 불일치");
        }
        post.update(requestDto);
        return PostResponseDto.success(postRepository.findById(id));
    }

    //글 삭제
    public PostResponseDto<String> deletePost(Long id) {
        Member member = memberService.getInfo();
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        //게시글 작성자
        Member member2 = post.getMember();
        if(!member.getId().equals(member2.getId())){
            throw new IllegalArgumentException("id 불일치");
        }
        postRepository.deleteById(id);
        return PostResponseDto.success("delete success");
    }

}

