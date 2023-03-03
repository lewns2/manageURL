package com.lewns2.backend.rest.dto.url.response;

import com.lewns2.backend.model.Url;
import lombok.Getter;

@Getter
public class UrlResponse {
    private String address;
    private String category;

    private UrlResponse() {};

    private UrlResponse(String address, String category) {
        this.address = address;
        this.category = category;
    }

    public static UrlResponse from(final Url url) {
        return new UrlResponse(url.getAddress(), url.getCategory());
    }
}
