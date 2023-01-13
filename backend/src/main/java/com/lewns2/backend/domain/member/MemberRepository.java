package com.lewns2.backend.domain.member;

public interface MemberRepository{

    void save(Member member);

    Member findMemberById(Long memberId);
}
