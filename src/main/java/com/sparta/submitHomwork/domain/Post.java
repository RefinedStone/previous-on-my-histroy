package com.sparta.submitHomwork.domain;

import com.sparta.submitHomwork.dto.PostRequestDto;
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
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = true)
    private String contents;
    public Post(String username, String contents, String title) {
        this.username = username;
        this.contents = contents;
        this.title = title;
    }
    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }


}
