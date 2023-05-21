package com.sparta.jwt_submit_try4.jwt.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.jwt_submit_try4.controller.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Post extends Timestamped{

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private String contents;

    @Column(nullable = true)
    private String nickname;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="member_Id")
    private Member member;

    //One post to Many comment
    @OneToMany(mappedBy = "post")
    private List<Comment> comment;

    public Post(String contents, String title) {
        this.contents = contents;
        this.title = title;
    }
    public Post(PostRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
    public Post(PostRequestDto requestDto,Member member) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.member = member;
        this.nickname = member.getNickname();
    }

    public void update(PostRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
