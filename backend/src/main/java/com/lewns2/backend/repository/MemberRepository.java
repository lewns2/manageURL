package com.lewns2.backend.repository;

import com.lewns2.backend.model.Member;

public interface MemberRepository{

    void save(Member member);

    Member findMemberById(Long memberId);

    Member findMemberByNickName(String nickName);
}
