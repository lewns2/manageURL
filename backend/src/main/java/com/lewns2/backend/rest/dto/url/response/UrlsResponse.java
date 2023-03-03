package com.lewns2.backend.rest.dto.url.response;

import com.lewns2.backend.model.Url;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UrlsResponse {

    private Collection<UrlResponse> urls;

    private UrlsResponse() {}

    private UrlsResponse(Collection<UrlResponse> urls) {
        this.urls = urls;
    }

    public static UrlsResponse from(final Collection<Url> urls) {
        return new UrlsResponse(urls.stream()
                        .map(UrlResponse::from)
                        .collect(Collectors.toList()));
    }
}
