package com.lewns2.backend.service.url;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;

import java.util.Collection;

public interface UrlService {

    void doSaveUrls(Collection<Url> urls);

    Collection<Url> findBoardUrls(Board board);

    Collection<Url> findMemberUrls(Collection<Board> boards);

    void deleteUrl(Url url);

    void updateUrls(Board board, Collection<Url> urls);
}
