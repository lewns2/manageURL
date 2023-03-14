package com.lewns2.backend.rest.dto.url.response;

import com.lewns2.backend.model.Url;
import lombok.Getter;

@Getter
public class UrlResponse {
    private String address;
    private String category;
    private Long boardId;
    private String boardTitle;

    private UrlResponse() {};

    private UrlResponse(String address, String category) {
        this.address = address;
        this.category = category;
    }

    private UrlResponse(String address, String category, Long boardId, String boardTitle) {
        this.address = address;
        this.category = category;
        this.boardId = boardId;
        this.boardTitle = boardTitle;
    }

    public static UrlResponse from(final Url url) {
        return new UrlResponse(url.getAddress(), url.getCategory(), url.getBoard().getId(), url.getBoard().getTitle());
    }
}
