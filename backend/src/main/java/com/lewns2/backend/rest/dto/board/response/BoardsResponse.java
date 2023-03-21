package com.lewns2.backend.rest.dto.board.response;

import com.lewns2.backend.model.Board;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Getter
public class BoardsResponse {
    private List<BoardResponse> boards;
    private int countBoards;
    private Map<LocalDate, List<BoardResponse>> boardsGroupByDate;

    private BoardsResponse() {}

    private BoardsResponse(List<BoardResponse> boards) {
        this.boards = boards;
    }

    public BoardsResponse(int countBoards, Map<LocalDate, List<BoardResponse>> boarsGroupingByDate) {
        this.countBoards = countBoards;
        this.boardsGroupByDate = boarsGroupingByDate;
    }

    // 게시글 일반 조회
    public static BoardsResponse from(Collection<Board> boards) {
        return new BoardsResponse(boards.stream().map(BoardResponse::getBoardWithoutUrls).collect(Collectors.toList()));
    }

    // 게시글 날짜별 그룹화
    public static BoardsResponse getBoarsGroupByDate(Collection<Board> boards) {
        return new BoardsResponse(
                boards.size(),
                boards.stream()
                        .map(BoardResponse::getBoardWithoutUrls)
                        .collect(Collectors.groupingBy(BoardResponse::getUpdateDate)));
    }
}
