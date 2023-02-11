package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.rest.dto.board.BoardResponse;
import com.lewns2.backend.rest.dto.board.CreateBoardRequest;
import com.lewns2.backend.rest.dto.board.UpdateBoardRequest;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import com.lewns2.backend.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
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
    public ResponseEntity<BoardResponse>  createBoard(@RequestBody CreateBoardRequest request) {

        // 회원 조회
        String memberNickName = request.getNickName();
        Member member = memberService.findMemberByNickName(memberNickName);
        if(member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 게시글 작성
        Board board = request.toEntity(member);
        Long id = boardService.doSaveArticle(board);

        // URL 저장
        Collection<Url> urls = request.toEntityUrl(board, request.getUrls());
        urlService.doSaveUrls(urls);

        return new ResponseEntity<>(BoardResponse.from(id), HttpStatus.OK);
    }

    // 게시글 조회
    @GetMapping("/board/{nickName}")
    public ResponseEntity<Collection<Board>> getBoard(@PathVariable String nickName) {
        Member member = memberService.findMemberByNickName(nickName);
        Collection<Board> boardRes = boardService.findBoardByMemberId(member.getId());

        return new ResponseEntity<>(boardRes, HttpStatus.OK);
    }

    // 게시글 삭제
    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable int id) {
        Long boardId = Long.valueOf(id);
        boardService.deleteArticle(boardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 게시글 수정
    @PutMapping("/board/{id}")
    public ResponseEntity<Long> updateBoard(@RequestBody UpdateBoardRequest request, @PathVariable int id) {

        // 회원 조회
        String memberNickName = request.getNickName();
        Member member = memberService.findMemberByNickName(memberNickName);

        Long boardId = Long.valueOf(id);
        Board board = request.toEntity(member);

        Long resId = boardService.updateArticle(board, boardId);

        return new ResponseEntity<>(resId, HttpStatus.OK);
    }

}
