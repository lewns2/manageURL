package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.rest.dto.board.BoardResponse;
import com.lewns2.backend.rest.dto.board.CreateBoardRequest;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BoardRestController {

    private final BoardService boardService;
    private final MemberService memberService;

    // 생성자
    public BoardRestController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    // 게시글 작성
    @PostMapping("/board")
    public BoardResponse createBoard(@RequestBody CreateBoardRequest request) {
        String memberNickName = request.getNickname();
        Member member = memberService.findMemberByNickName(memberNickName);

        Board board = request.toEntity(member);
        Long id = boardService.doSaveArticle(board);

        return BoardResponse.from(id);
    }

    // 게시글 조회
    @GetMapping("/board/{nickName}")
    public Collection<Board> getBoard(@PathVariable String nickName) {
        Member member = memberService.findMemberByNickName(nickName);
        System.out.println(member);
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
