package com.lewns2.backend.config;

import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.repository.memory.MemoryMemberRepositoryImpl;
import com.lewns2.backend.service.MemberService;
import com.lewns2.backend.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration()
public class MemberConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
