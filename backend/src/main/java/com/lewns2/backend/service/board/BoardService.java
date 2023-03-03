package com.lewns2.backend.service.board;

import com.lewns2.backend.model.Board;

import java.util.Collection;

public interface BoardService {

    Long doSaveArticle(Board board);

    Board findBoardById(Long boardId);

    Collection<Board> findBoardByMemberId(Long memberId);

    void deleteArticle(Long boardId);

    Long updateArticle(Board board, Long boardId);

}
