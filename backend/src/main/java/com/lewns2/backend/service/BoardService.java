package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;

import java.util.Collection;

public interface BoardService {

    Long doSaveArticle(Board board);

    Board findBoardById(Long boardId);

    Collection<Board> findBoardByMemberId(Long memberId);

    void deleteArticle(Long boardId);

    Long updateArticle(Board board, Long boardId);

}
