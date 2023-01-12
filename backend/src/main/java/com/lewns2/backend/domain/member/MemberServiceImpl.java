package com.lewns2.backend.domain.member;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    // 의존성 낮추기 : memberRepository가 어떤 구현체인지 여기서 선택하면 안된다.
    private final MemberRepository memberRepository;

    // MemberConfig에서 접근하기 위한 생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void doSignUp(Member member) {
        memberRepository.save(member);
    }
}
