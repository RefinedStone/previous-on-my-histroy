package com.sparta.jwt_submit_try4.controller.dto;

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
    //private final MemberRepository memberRepository2;


}