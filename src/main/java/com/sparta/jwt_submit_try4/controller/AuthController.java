package com.sparta.jwt_submit_try4.controller;


import com.sparta.jwt_submit_try4.controller.dto.*;
import com.sparta.jwt_submit_try4.entity.Member;
import com.sparta.jwt_submit_try4.entity.RefreshToken;
import com.sparta.jwt_submit_try4.jwt.TokenProvider;
import com.sparta.jwt_submit_try4.repository.MemberRepository;
import com.sparta.jwt_submit_try4.repository.RefreshTokenRepository;
import com.sparta.jwt_submit_try4.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    //위까지 서비스단
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDtoTest<?>> signup(@RequestBody @Valid MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDtoTest<Optional<Member>>> login(@RequestBody MemberRequestDto memberRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = memberRequestDto.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();
        refreshTokenRepository.save(refreshToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, tokenDto.getAccessToken());
        headers.add("refreshToken", tokenDto.getRefreshToken());
        Optional<Member> memberTemp = memberRepository.findBynickname(memberRequestDto.getNickname());
        return ResponseEntity.ok().headers(headers).body(MemberResponseDtoTest.success(memberTemp));
    }


    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }


}
