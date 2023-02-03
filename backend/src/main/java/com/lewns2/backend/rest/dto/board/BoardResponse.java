package com.lewns2.backend.rest.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class BoardResponse {
    private Long boardId;

    public static BoardResponse from(Long id) {
        return new BoardResponse(id);
    }
}
