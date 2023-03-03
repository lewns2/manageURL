package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.service.board.BoardService;
import com.lewns2.backend.service.member.MemberService;
import com.lewns2.backend.service.url.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UrlRestController {

    private MemberService memberService;
    private BoardService boardService;
    private UrlService urlService;

    public UrlRestController(MemberService memberService, BoardService boardService, UrlService urlService) {
        this.memberService = memberService;
        this.boardService = boardService;
        this.urlService = urlService;
    }

    // 특정 회원의 URL 전체 조회
    @GetMapping("/urls/{nickName}")
    public ResponseEntity<?> getUrls(@PathVariable String nickName) {

        Member member = memberService.findMemberByNickName(nickName);
        Collection<Board> boardRes = boardService.findBoardByMemberId(member.getId());

        Collection<Url> findUrls = urlService.findMemberUrls(boardRes);

        return new ResponseEntity<>(findUrls, HttpStatus.OK);
    }

}
