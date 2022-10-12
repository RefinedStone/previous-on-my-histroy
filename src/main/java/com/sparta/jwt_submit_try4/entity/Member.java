package com.sparta.jwt_submit_try4.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member extends Timestamped{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String nickname, String password, Authority authority) {
        this.nickname = nickname;
        this.password = password;
        this.authority = authority;
    }
}
