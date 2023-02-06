package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    @Transactional
    public Long doSaveArticle(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    @Override
    public Board findBoardById(Long boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    @Transactional
    public Collection<Board> findBoardByMemberId(Long memberId) {
        return boardRepository.findByMemberId(memberId);
    }

    @Override
    @Transactional
    public void deleteArticle(Long boardId) {
        boardRepository.delete(boardId);
    }
}
