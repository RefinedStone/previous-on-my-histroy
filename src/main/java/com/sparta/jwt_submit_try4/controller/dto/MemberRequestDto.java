package com.sparta.jwt_submit_try4.controller.dto;


import com.sparta.jwt_submit_try4.entity.Authority;
import com.sparta.jwt_submit_try4.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    @Pattern(regexp = "^[a-z0-9]{4,8}$",message = "아이디는 소문자 4-8자만 허용")
    @NotBlank(message = "여백금지")
    private String nickname;
    @Pattern(regexp = "^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[~!@#$%^&*()+|=]).{8,20}$",message = "비밀번호 영+특+숫 포함 8-20자 허용")
    @NotBlank(message = "비밀번호에 여백orNull 금지")
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(nickname, password);
    }
}
