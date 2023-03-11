package com.lewns2.backend.repository;

import com.lewns2.backend.model.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    void save(Board board);

    Optional<Board> findById(Long boardId);

    List<Board> findByMemberId(Long memberId);

    void delete(Long boardId);
}
