package com.sparta.jwt_submit_try4.entity;


import com.sparta.jwt_submit_try4.controller.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column(nullable = false)
//    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private String contents;
    public Post(String contents, String title) {
        this.contents = contents;
        this.title = title;
    }
    public Post(PostRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void update(PostRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }


}
