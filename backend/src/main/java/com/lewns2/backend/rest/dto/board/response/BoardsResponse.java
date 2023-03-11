package com.lewns2.backend.rest.dto.board.response;

import com.lewns2.backend.model.Board;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class BoardsResponse {
    private List<BoardResponse> boards;

    private BoardsResponse() {}

    private BoardsResponse(List<BoardResponse> boards) {
        this.boards = boards;
    }

    public static BoardsResponse from(Collection<Board> boards) {
        return new BoardsResponse(boards.stream().map(BoardResponse::getBoardWithoutUrls).collect(Collectors.toList()));
    }
}
