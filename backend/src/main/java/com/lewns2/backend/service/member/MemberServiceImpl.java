package com.lewns2.backend.service.member;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.rest.exception.badrequest.InvalidPasswordException;
import com.lewns2.backend.rest.exception.notfound.MemberNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

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
    public Long doSignUp(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    @Transactional
    public String doLogin(Member member) {

        // Optional
        Member findMember = memberRepository.findMemberByEmail(member.getEmail()).orElseThrow(MemberNotFoundException::new);

        if(!Objects.equals(findMember.getPassword(), member.getPassword())) {
            throw new InvalidPasswordException();
        }

        return findMember.getNickName();
    }

    @Override
    @Transactional
    public Member findMember(Long memberId) {
        return memberRepository.findMemberById(memberId);
    }

    @Override
    @Transactional
    public Member findMemberByNickName(String nickname) {
        return memberRepository.findMemberByNickName(nickname);
    }

}
