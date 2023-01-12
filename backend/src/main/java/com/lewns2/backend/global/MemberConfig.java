package com.lewns2.backend.global;

import com.lewns2.backend.domain.member.MemberRepository;
import com.lewns2.backend.domain.member.MemberService;
import com.lewns2.backend.domain.member.MemberServiceImpl;
import com.lewns2.backend.domain.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
