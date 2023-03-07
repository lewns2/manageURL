package com.lewns2.backend.repository;

import com.lewns2.backend.model.Member;

import java.util.Optional;


public interface MemberRepository{

    void save(Member member);

    Member findMemberById(Long memberId);

    Optional<Member> findMemberByNickName(String nickName);

    Optional<Member> findMemberByEmail(String email);
}
