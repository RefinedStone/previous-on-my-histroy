package com.sparta.jwt_submit_try4.entity;


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

    // ManyToOne, OneToMany 양방향 연관관계에서 ManyToOne이 연관관계의 주인이 됩니다.
    // 연관관계의 주인이란 상대방의 primary key(PK)를 관리하는 것입니다. 이를 foreign key (외래키) 라고 합니다.
    // 연관 관계의 주인 쪽에서 저장 수정쪽에서 나타납니다.
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String contents) {
        this.comments = contents;
    }
    public Comment(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }

    // requestDto, post를 받아서 comment를 생성할께 (구현)
    public Comment(CommentRequestDto requestDto, Post post) {
        this.comments = requestDto.getComments();
        this.post = post;
    }

    public void update(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }


}
