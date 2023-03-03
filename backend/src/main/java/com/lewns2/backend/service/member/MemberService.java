package com.lewns2.backend.service.member;


import com.lewns2.backend.model.Member;

import java.util.Optional;

public interface MemberService {

    Long doSignUp(Member member);

    String doLogin(Member member);

    Member findMember(Long memberId);

    Member findMemberByNickName(String nickname);

}
