package com.lewns2.backend.rest.dto.member.response;

public class SignUpResponse {
    private Long memberId;

    // 정적 팩토리 메서드 패턴
    public static SignUpResponse from(Long id) {
        return new SignUpResponse(id);
    }

    // 생성자
    public SignUpResponse(Long memberId) {
        this.memberId = memberId;
    }

    // getter and setter
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
