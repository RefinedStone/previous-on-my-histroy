package com.sparta.jwt_submit_try4.service;


import com.sparta.jwt_submit_try4.controller.dto.MemberResponseDtoTest;
import com.sparta.jwt_submit_try4.controller.dto.PostRequestDto;
import com.sparta.jwt_submit_try4.controller.dto.PostResponseDto;
import com.sparta.jwt_submit_try4.entity.Member;
import com.sparta.jwt_submit_try4.entity.Post;
import com.sparta.jwt_submit_try4.repository.MemberRepository;
import com.sparta.jwt_submit_try4.repository.PostRepository;
import com.sparta.jwt_submit_try4.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private MemberRepository memberRepository;

    @Transactional
    public Member getMyInfo() {
        Member tempMember = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        // String tempMemberNickname= tempMember.getNickname();
        return tempMember;
    }
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 모든 글 읽어오기
    public List<Post> getAllpost() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    //글 쓰기
    public PostResponseDto<?> createPost(PostRequestDto requestDto) {
        //Member myInfo = getMyInfo();
        Post post = new Post(requestDto);
        //Post post = new Post(requestDto,myInfo);
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

