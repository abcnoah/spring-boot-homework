package com.sparta.homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class User extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String address;

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public User(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.address = requestDto.getAddress();
    }

    public void update(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.address = requestDto.getAddress();
    }
}