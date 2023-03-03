package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.rest.dto.board.response.BoardIdResponse;
import com.lewns2.backend.rest.dto.board.request.CreateBoardRequest;
import com.lewns2.backend.rest.dto.board.request.UpdateBoardRequest;
import com.lewns2.backend.rest.dto.board.response.BoardsResponse;
import com.lewns2.backend.service.board.BoardService;
import com.lewns2.backend.service.member.MemberService;
import com.lewns2.backend.service.url.UrlService;
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
    public ResponseEntity<BoardIdResponse>  createBoard(@RequestBody CreateBoardRequest request) {

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

        return new ResponseEntity<>(BoardIdResponse.from(id), HttpStatus.OK);
    }

    // 게시글 조회
    @GetMapping("/board/{nickName}")
    public ResponseEntity<BoardsResponse> getBoard(@PathVariable String nickName) {
        Member member = memberService.findMemberByNickName(nickName);
        Collection<Board> boardRes = boardService.findBoardByMemberId(member.getId());

        return new ResponseEntity<>(BoardsResponse.from(boardRes), HttpStatus.OK);
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

        // 게시글 수정
        Long boardId = Long.valueOf(id);
        Board board = request.toEntity(member);
        Long resId = boardService.updateArticle(board, boardId);

        // URL 수정
        Collection<Url> urls = request.toEntityUrl(board, request.getUrls());
        urlService.updateUrls(board, urls);

        return new ResponseEntity<>(resId, HttpStatus.OK);
    }

}
