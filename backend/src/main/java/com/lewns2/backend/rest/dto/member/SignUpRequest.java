package com.lewns2.backend.rest.dto.member;

import com.lewns2.backend.model.Member;

public class SignUpRequest {
    private String nickname;
    private String email;
    private String password;

    // 빌더 패턴
    public Member toEntity() {
        return Member.builder()
                .nickname(nickname)
                .email(email)
                .password(password)
                .build();
    }

    // 생성자
    public SignUpRequest() {}

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
        return nickname;
    }

    public void setNickName(String nickName) {
        this.nickname = nickName;
    }
}
