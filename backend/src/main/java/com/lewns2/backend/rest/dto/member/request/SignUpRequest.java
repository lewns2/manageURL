package com.lewns2.backend.rest.dto.member.request;

import com.lewns2.backend.model.Member;


public class SignUpRequest {
    private String nickName;
    private String email;
    private String password;

    // 빌더 패턴
    public Member toEntity() {
        return Member.builder()
                .nickname(nickName)
                .email(email)
                .password(password)
                .build();
    }

    // 생성자
    public SignUpRequest() {};

    // getter and setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
