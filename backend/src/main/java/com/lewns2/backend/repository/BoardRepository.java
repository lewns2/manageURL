package com.lewns2.backend.repository;

import com.lewns2.backend.model.Board;

import java.util.List;

public interface BoardRepository {

    void save(Board board);

    Board findById(Long boardId);

    List<Board> findByMemberId(Long memberId);

    void delete(Board board);
}
