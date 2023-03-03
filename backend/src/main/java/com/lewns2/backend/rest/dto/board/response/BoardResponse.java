package com.lewns2.backend.rest.dto.board.response;

import com.lewns2.backend.model.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
    String title;
    String description;

    private BoardResponse() {};

    private BoardResponse(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static BoardResponse from(final Board board) {
        return new BoardResponse(board.getTitle(), board.getDescription());
    }
}
