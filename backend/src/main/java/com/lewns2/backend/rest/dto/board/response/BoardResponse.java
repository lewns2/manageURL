package com.lewns2.backend.rest.dto.board.response;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BoardResponse {
    Long boardId;
    String title;
    String description;
    LocalDate createDate;
    LocalDate updateDate;
    List Urls;

    private BoardResponse() {};

    private BoardResponse(Long boardId, String title, String description, LocalDate createDate, LocalDate updateDate) {
        this.boardId = boardId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    private BoardResponse(Long boardId, String title, String description, LocalDate createDate, LocalDate updateDate, List urls) {
        this.boardId = boardId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.Urls = urls;
    }

    public static BoardResponse getBoardWithoutUrls(final Board board) {
        return new BoardResponse(board.getId(), board.getTitle(), board.getDescription(), board.getCreatedDate(), board.getUpdateDate());
    }

    public static BoardResponse getBoardWithUrls(final Board board) {
        return new BoardResponse(board.getId(), board.getTitle(), board.getDescription(), board.getCreatedDate(), board.getUpdateDate(), board.getUrls());
    }
}
