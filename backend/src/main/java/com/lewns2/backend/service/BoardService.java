package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;

import java.util.Collection;

public interface BoardService {

    void doSaveArticle(Board board);

    Collection<Board> findBoardByMemberId(Long memberId);

}
