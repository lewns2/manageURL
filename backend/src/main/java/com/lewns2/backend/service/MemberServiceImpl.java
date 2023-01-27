package com.lewns2.backend.service;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    // 의존성 낮추기 : memberRepository가 어떤 구현체인지 여기서 선택하면 안된다.
    private final MemberRepository memberRepository;

    // MemberConfig에서 접근하기 위한 생성자
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public void doSignUp(Member member) {
        memberRepository.save(member);
    }

    @Override
    @Transactional
    public Member findMember(Long memberId) {
        return memberRepository.findMemberById(memberId);
    }


}
