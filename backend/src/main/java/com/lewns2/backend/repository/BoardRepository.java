package com.lewns2.backend.repository;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;

import java.util.List;
import java.util.Set;

public interface BoardRepository {

    void save(Board board);

    Board findById(Long boardId);

    List<Board> findByMemberId(Long memberId);

    void delete(Board board);
}
