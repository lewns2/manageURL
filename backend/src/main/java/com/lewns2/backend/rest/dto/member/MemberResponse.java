package com.lewns2.backend.rest.dto.member;

public class MemberResponse {
    private Long memberId;

    // 정적 팩토리 메서드 패턴
    public static MemberResponse from(Long id) {
        return new MemberResponse(id);
    }

    // 생성자
    public MemberResponse(Long memberId) {
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
