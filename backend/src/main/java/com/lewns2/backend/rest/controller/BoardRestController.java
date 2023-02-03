package com.lewns2.backend.rest.controller;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.rest.dto.board.BoardResponse;
import com.lewns2.backend.rest.dto.board.CreateBoardRequest;
import com.lewns2.backend.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardRestController {

    private final BoardService boardService;

    // 생성자
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 작성
    @PostMapping("/board")
    public BoardResponse createBoard(@RequestBody CreateBoardRequest request) {
        Board board = request.toEntity();
        Long id = boardService.doSaveArticle(board);

        return BoardResponse.from(id);
    }
}
