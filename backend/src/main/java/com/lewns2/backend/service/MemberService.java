package com.lewns2.backend.service;


import com.lewns2.backend.model.Member;

public interface MemberService {

    Long doSignUp(Member member);

    Member findMember(Long memberId);

}
