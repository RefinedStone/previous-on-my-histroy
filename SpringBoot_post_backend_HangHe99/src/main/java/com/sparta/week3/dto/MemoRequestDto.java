package com.sparta.week3.dto;

import com.sparta.week3.domain.Timestamped;
import lombok.Getter;

@Getter
public class MemoRequestDto extends Timestamped {
    private String username;
    private String contents;
    private String password;



}