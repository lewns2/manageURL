package com.lewns2.backend.rest.dto.board.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class BoardIdResponse {
    private Long boardId;

    public static BoardIdResponse from(Long id) {
        return new BoardIdResponse(id);
    }
}
