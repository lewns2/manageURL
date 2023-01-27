package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;

import java.util.Collection;

public interface UrlService {

    void doSaveUrls(Collection<Url> urls);

    Collection<Url> findUrls(Board board);

    void deleteUrl(Url url);
}
