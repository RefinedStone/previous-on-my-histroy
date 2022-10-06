package com.sparata.testsubmit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparata.testsubmit.entity.MemberInfoResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
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
public class Member{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    //패스워드 추가
    @JsonIgnore
    @Column(nullable = true)
    private String pw;

    @CreatedDate
    @Column(nullable = true)
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime modifiedTime;

    public Member(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }
    public Member(MemberInfoResponseDto responseDto) {
        this.name = responseDto.getName();
        this.email = responseDto.getEmail();
        this.pw = responseDto.getPw();
    }

    public void findMember(MemberInfoResponseDto responseDto) {
        this.name = responseDto.getName();
        this.email = responseDto.getEmail();
        this.pw = responseDto.getPw();
    }
    public void findAllMember(MemberInfoResponseDto responseDto) {
        this.name = responseDto.getName();
        this.email = responseDto.getEmail();
        this.pw = responseDto.getPw();
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }


}