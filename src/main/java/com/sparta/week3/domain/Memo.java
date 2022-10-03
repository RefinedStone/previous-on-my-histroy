package com.sparta.week3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.week3.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
// 생성,수정 시간을 자동으로 만들어줍니다.
public class Memo extends Timestamped {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    //패스워드 추가
    @JsonIgnore
    @Column(nullable = true)
    private String password;

    @CreatedDate
    @Column(nullable = true)
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime modifiedTime;

    public Memo(String username, String contents, String password) {
        this.username = username;
        this.contents = contents;
        this.password = password;
    }
    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}