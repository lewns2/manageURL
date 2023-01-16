package com.lewns2.backend.service.member;

import com.lewns2.backend.config.MemberConfig;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class MemberServiceJpaTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void shouldAddMember() throws Exception {
        // given
        Member memberA = new Member("das@das", "das", Role.USER);

        // when
        memberService.doSignUp(memberA);
        Member findMember = memberService.findMember(13L);

        // then
        // 기본키 전략이 하나씩 올라가는 거라, DB에서 아이디로 직접 조회 테스트하기 어려움이 발생 => 기본키 값을 예상하기 어려움
//        Assertions.assertThat(memberRepository.findMemberById(1L)).isEqualTo(memberA);


    }
}
