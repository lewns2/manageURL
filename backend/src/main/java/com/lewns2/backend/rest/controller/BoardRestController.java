package com.lewns2.backend.rest.controller;

import ch.qos.logback.classic.html.UrlCssBuilder;
import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.rest.dto.board.BoardResponse;
import com.lewns2.backend.rest.dto.board.CreateBoardRequest;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import com.lewns2.backend.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final UrlService urlService;

    // 생성자
    public BoardRestController(BoardService boardService, MemberService memberService, UrlService urlService) {
        this.boardService = boardService;
        this.memberService = memberService;
        this.urlService = urlService;
    }

    // 게시글 작성
    @PostMapping("/board")
    public BoardResponse createBoard(@RequestBody CreateBoardRequest request) {

        // 회원 조회
        String memberNickName = request.getNickname();
        Member member = memberService.findMemberByNickName(memberNickName);

        // 게시글 작성
        Board board = request.toEntity(member);
        Long id = boardService.doSaveArticle(board);

        // URL 저장
        Collection<Url> urls = request.toEntityUrl(board, request.getUrls());
        urlService.doSaveUrls(urls);

        return BoardResponse.from(id);
    }

    // 게시글 조회
    @GetMapping("/board/{nickName}")
    public Collection<Board> getBoard(@PathVariable String nickName) {
        Member member = memberService.findMemberByNickName(nickName);
        Collection<Board> boardRes = boardService.findBoardByMemberId(member.getId());
        return boardRes;
    }

    // 게시글 삭제
    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable int id) {
        Long boardId = Long.valueOf(id);
        boardService.deleteArticle(boardId);
        return;
    }
}
