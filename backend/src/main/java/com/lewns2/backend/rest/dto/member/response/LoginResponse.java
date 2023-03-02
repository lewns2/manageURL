package com.lewns2.backend.rest.dto.member.response;


public class LoginResponse {

    private String nickName;

    public static LoginResponse from(String nickName) {
        return new LoginResponse(nickName);
    }

    // 생성자
    public LoginResponse(String nickName) {
        this.nickName = nickName;
    }

    // getter and setter
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
