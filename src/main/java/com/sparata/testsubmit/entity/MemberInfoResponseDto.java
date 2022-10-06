package com.sparata.testsubmit.entity;

import com.sparata.testsubmit.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberInfoResponseDto {

    private Long id;
    private String name;
    private String email;
    private String pw;

    public MemberInfoResponseDto(Long id, String name, String email, String pw) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pw = pw;
    }

    //    public MemberInfoResponseDto(Member member) {
//      this.id =id;
//      this.name=name;
//      this.email=email;
//      this.pw=pw;
//
//    }

}