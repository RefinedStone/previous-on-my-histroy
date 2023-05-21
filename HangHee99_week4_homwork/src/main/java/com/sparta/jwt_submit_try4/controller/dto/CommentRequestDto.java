package com.sparta.jwt_submit_try4.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    // 댓글 내용
    private String comments;
    private Long postId;
}
