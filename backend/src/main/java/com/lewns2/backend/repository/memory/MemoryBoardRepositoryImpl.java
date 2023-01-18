package com.lewns2.backend.repository.memory;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.repository.BoardRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryBoardRepositoryImpl implements BoardRepository {

    // 임시 저장소
    private static Map<Long, Board> store = new ConcurrentHashMap<>();

    @Override
    public void save(Board board) {
        store.put(board.getId(), board);
    }
}
