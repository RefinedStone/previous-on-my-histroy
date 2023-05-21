package com.sparta.jwt_submit_try4.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto<T> {
    private boolean success;
    private T data;
    private Error error;

    public static <T> CommentResponseDto<T> success(T data) {
        return new CommentResponseDto<>(true,data,null);
    }

    @Getter
    @AllArgsConstructor
    static class Error {
        private String code;
        private String message;
    }
}