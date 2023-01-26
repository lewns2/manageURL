package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;

import java.util.Collection;

public interface BoardService {

    void doSaveArticle(Board board);

    Board findBoardById(Long boardId);

    Collection<Board> findBoardByMemberId(Long memberId);

    void deleteArticle(Board board);

}
