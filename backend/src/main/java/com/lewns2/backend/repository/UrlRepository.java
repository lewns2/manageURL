package com.lewns2.backend.repository;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;

import java.util.List;


public interface UrlRepository {

    void save(Url url);

    List<Url> findUrls(Board board);

    void delete(Url url);
}
