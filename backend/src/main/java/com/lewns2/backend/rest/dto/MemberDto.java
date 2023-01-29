package com.lewns2.backend.rest.dto;

public class MemberDto {
    private String email;

    public MemberDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
