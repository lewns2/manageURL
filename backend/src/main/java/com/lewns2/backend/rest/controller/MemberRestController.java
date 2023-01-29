package com.lewns2.backend.rest.controller;

import com.lewns2.backend.mapper.MemberMapper;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.rest.dto.MemberDto;
import com.lewns2.backend.service.MemberService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberRestController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    // 생성자
    public MemberRestController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    // 회원 등록
    @PostMapping("/members")
    public ResponseEntity<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        /* 1. 요청 memberDto를 member 엔티티로 변환
        // 2. 서비스 호출 : 등록
        // 3, dto를 반환 */
        HttpHeaders headers = new HttpHeaders();

        Member member = memberMapper.toMember(memberDto);
        memberService.doSignUp(member);

        return new ResponseEntity<>(memberMapper.toMemberDto(member), headers, HttpStatus.CREATED);


    }
}
