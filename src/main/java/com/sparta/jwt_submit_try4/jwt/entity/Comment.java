package com.sparta.jwt_submit_try4.jwt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    // many comment to one post
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="post")
    private Post post;

    @Column(nullable = true)
    private Long post_id;

    public Comment(String contents) {
        this.comments = contents;
    }
    public Comment(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }

    //comment-post를 받는 생성자 추가
    public Comment(CommentRequestDto requestDto, Post post) {
        this.comments = requestDto.getComments();
        this.post = post;
    }
    public Comment(CommentRequestDto requestDto, Long post_id) {
        this.comments = requestDto.getComments();
        this.post_id = post_id;
    }

    public void update(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }



}
