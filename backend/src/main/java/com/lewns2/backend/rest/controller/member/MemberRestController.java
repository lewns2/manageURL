package com.lewns2.backend.rest.controller.member;

import com.lewns2.backend.model.Member;
import com.lewns2.backend.rest.dto.member.request.LoginRequest;
import com.lewns2.backend.rest.dto.member.request.SignUpRequest;
import com.lewns2.backend.rest.dto.member.response.LoginResponse;
import com.lewns2.backend.rest.dto.member.response.SignUpResponse;
import com.lewns2.backend.rest.exception.ExceptionResponse;
import com.lewns2.backend.service.member.MemberService;
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
    public ResponseEntity<SignUpResponse> addMember(@RequestBody SignUpRequest signUpRequest) {

        Member member = signUpRequest.toEntity();
        Long id = memberService.doSignUp(member);

        return new ResponseEntity<>(SignUpResponse.from(id), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginMember(@RequestBody LoginRequest loginRequest) {

        Member member = loginRequest.toEntity();
        String findNickName = memberService.doLogin(member);

        return new ResponseEntity<>(LoginResponse.from(findNickName), HttpStatus.OK);
    }

    // 닉네임 중복 확인
    @GetMapping("/signup/nickname/check")
    public ResponseEntity<Boolean> checkNickName(@RequestParam("nickname") String nickName) {

        boolean res = memberService.isAvailableNickName(nickName);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // 이메일 중복 확인
    @GetMapping("/signup/email/check")
    public ResponseEntity<Boolean> checkEmail(@RequestParam("email") String email) {

        boolean res = memberService.isAvailableEmail(email);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
