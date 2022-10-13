package com.sparta.jwt_submit_try4.entity;


import com.sparta.jwt_submit_try4.controller.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private String comments;

    public Comment(String contents) {
        this.comments = contents;
    }
    public Comment(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }

    public void update(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }


}
