package com.sparta.jwt_submit_try4.controller.dto;

import com.sparta.jwt_submit_try4.entity.Member;
import com.sparta.jwt_submit_try4.repository.MemberRepository;
import com.sparta.jwt_submit_try4.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto<T> {
    private boolean success;
    private T data;
    //private String nickname;
    private Error error;

    public static <T> PostResponseDto<T> success(T data) {
        return new PostResponseDto<>(true,data,null);
    }
    @Getter
    @AllArgsConstructor
    static class Error {
        private String code;
        private String message;
    }
}