package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.rest.dto.member.MemberResponse;
import com.lewns2.backend.rest.dto.member.SignUpRequest;
import com.lewns2.backend.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MemberRestController {

    private final MemberService memberService;

    // 생성자
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 등록
    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> addMember(@RequestBody SignUpRequest signUpRequest) {
        /* 1. 요청 memberDto를 member 엔티티로 변환
        // 2. 서비스 호출 : 등록
        // 3, dto를 반환 */

        // 1. 빌더 패턴 사용해보기
        Member member = signUpRequest.toEntity();

        /* 2. 생성자로 만드는 방법
        Member member = new Member();
        member.setEmail(signUpRequest.getEmail());
        member.setPassword(signUpRequest.getPassword()); */

        Long id = memberService.doSignUp(member);
        return new ResponseEntity<>(MemberResponse.from(id), HttpStatus.OK);  // 3. 정적 팩토리 메서드 패턴
    }
}
