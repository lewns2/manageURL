package com.lewns2.backend.config;

import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.repository.jpa.JpaMemberRepositoryImpl;
import com.lewns2.backend.service.member.MemberService;
import com.lewns2.backend.service.member.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MemberConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepositoryImpl();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
}
