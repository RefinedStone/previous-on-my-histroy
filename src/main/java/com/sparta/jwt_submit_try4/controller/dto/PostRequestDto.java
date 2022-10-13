package com.sparta.jwt_submit_try4.controller.dto;

import com.sparta.jwt_submit_try4.entity.Member;
import com.sparta.jwt_submit_try4.repository.MemberRepository;
import com.sparta.jwt_submit_try4.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto {
    private String contents;
    private String title;
    private String nickname;
   // private MemberRepository memberRepository;


}