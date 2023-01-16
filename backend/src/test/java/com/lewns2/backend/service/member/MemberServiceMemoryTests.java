package com.lewns2.backend.service.member;

import com.lewns2.backend.config.MemberConfig;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceMemoryTests {

    // 빈 호출
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MemberConfig.class);

    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);

    @Test
    public void 회원객체_테스트() {
        // given
//        Member member = new Member(1L,"zlewns@gmail.com", "123", Role.USER);

        // when
//        memberService.doSignUp(member);
//
//        // then
//        System.out.println(memberRepository.findMemberById(1L));
//        Assertions.assertThat(memberRepository.findMemberById(1L)).isEqualTo(member);
    }


}
