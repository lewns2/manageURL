package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public void doSaveArticle(Board board) {
        boardRepository.save(board);
    }
}
