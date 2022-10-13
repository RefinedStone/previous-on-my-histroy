package com.sparta.jwt_submit_try4.controller.dto;

import com.sparta.jwt_submit_try4.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDtoTest {
    private String nickname;

  /*  public static MemberResponseDto of(Member member) {

        return new MemberResponseDto(member.getNickname());
    }*/
}
