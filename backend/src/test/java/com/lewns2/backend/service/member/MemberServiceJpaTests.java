package com.lewns2.backend.service.member;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.rest.dto.member.request.LoginRequest;
import com.lewns2.backend.rest.exception.ExceptionResponse;
import com.lewns2.backend.rest.exception.badrequest.InvalidPasswordException;
import com.lewns2.backend.rest.exception.notfound.MemberNotFoundException;
import com.lewns2.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@SpringBootTest
public class MemberServiceJpaTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @AfterEach
    public void afterEach() {
        clearRepository();
        teardown();
    }

    public void teardown() {
        this.em.createNativeQuery("ALTER TABLE members AUTO_INCREMENT=1").executeUpdate();
    }

    public void clearRepository() {
        this.em.createNativeQuery("DELETE FROM Members").executeUpdate();
    }


    @Test
    @Transactional
    public void 회원등록_테스트() throws Exception {
        // given
        Member memberA = new Member("dh", "test1@gmail.com", "test1", Role.USER);

        // when
        memberService.doSignUp(memberA);
        // 문제 : 새로운 회원(memberA)이 등록되는지 확인해야 하는데, 기본키 전략이 IDENTITY라 데이터베이스를 열어보지 않고선 기본키를 알기 힘들다.
        /* 해결 방안 생각해보기
        1. [보류] doSignUp 메서드가 id를 리턴하게 만든다. 근데 이건 테스트 코드만을 위한 코드 수정이 아닌가? 또, 리포지터리, 서비스 모두 수정해야한다.
        2. [보류] 리포지터리에 직접 등록하고 리포지터리의 save만 id를 리턴하게 만든다. 이것도 마찬가지로 테스트 코드만을 위한 코드 수정같은데. 또, 이러면 서비스(doSignUp)를 테스트하는 것이 아니게 된다.
        3. [O] 테스트 전, 데이터베이스를 리셋시키는 코드를 추가한다. -> 그럼 실제 DB와 테스트 DB가 분리되어야만 한다. 실제 회원들이 날아가면 안되니깐
        4. [X] 테스트 시, 넣었다가 롤백시키는 방법. -> 기본키 자체는 계속 증가하여, 여전히 기본키를 추적할 수 없다.
        5. spring data jpa에서는 deleteAllInBatch를 사용한다.
        */

        // 문제) 기본키 값은 초기화되지 않아 계속 올라간다.
        Member findMemberA = memberService.findMember(1L);
        Member findMemberB = memberService.findMemberByNickName("dh");
        System.out.println(findMemberA);
        System.out.println(findMemberB);

        // then
        Assertions.assertThat(findMemberA.getEmail()).isEqualTo(memberA.getEmail());
        Assertions.assertThat(findMemberA.getPassword()).isEqualTo(memberA.getPassword());
        Assertions.assertThat(findMemberA.getRole()).isEqualTo(memberA.getRole());

        Assertions.assertThat(findMemberB.getEmail()).isEqualTo(memberA.getEmail());
        Assertions.assertThat(findMemberB.getPassword()).isEqualTo(memberA.getPassword());
        Assertions.assertThat(findMemberB.getRole()).isEqualTo(memberA.getRole());


        // 회원을 찾을 때마다 매번 Member@xxxx, xxx의 값들(참조)이 계속 바뀐다. 왜??
        // 그래서 멤버 객체와 멤버 객체의 동등 비교는 참조 값이 다르기에 적절하지 않은 거 같다.
        // Assertions.assertThat(memberRepository.findMemberById(1L)).isEqualTo(findMember);
//        Assertions.assertThat(findMemberA.getEmail()).isEqualTo(memberA.getEmail());
    }

    @Test
    @Transactional
    public void 로그인_성공_테스트() throws Exception {
        // given
        Member memberA = new Member("dh", "test1@gmail.com", "test1", Role.USER);
        memberService.doSignUp(memberA);

        // when
        String res = memberService.doLogin(memberA);

        // then
        Assertions.assertThat(res).isEqualTo(memberA.getNickName());
    }

    @Test
    @Transactional
    public void 미회원가입_으로_인한_로그인_실패_테스트() throws Exception {
        // given
        Member memberA = new Member("dh", "test1@gmail.com", "test1", Role.USER);
        memberService.doSignUp(memberA);

        // when
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("wrong@gmail.com");
        loginRequest.setPassword("test1");
        Member LoginMember = loginRequest.toEntity();

        // then
        Assertions.assertThatThrownBy(() -> memberService.doLogin(LoginMember)).isInstanceOf(MemberNotFoundException.class);
    }

    @Test
    @Transactional
    public void 비밀번호_불일치로_인한_로그인_실패_테스트() throws Exception {
        // given
        Member memberA = new Member("dh", "test1@gmail.com", "test1", Role.USER);
        memberService.doSignUp(memberA);

        // when
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test1@gmail.com");
        loginRequest.setPassword("wrong");
        Member LoginMember = loginRequest.toEntity();

        // then
        Assertions.assertThatThrownBy(() -> memberService.doLogin(LoginMember)).isInstanceOf(InvalidPasswordException.class);
    }
}
