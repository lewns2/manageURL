package com.lewns2.backend.service.url;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    // 방식에 대해 고민이 더 필요해보임.
    @Override
    @Transactional
    public void doSaveUrls(Collection<Url> urls) {
        for(Url url : urls) {
            urlRepository.save(url);
        }
    }

    @Override
    @Transactional
    public Collection<Url> findBoardUrls(Board board) {
        return urlRepository.findUrls(board);
    }

    @Override
    public Collection<Url> findMemberUrls(Collection<Board> boards) {
        Collection<Url> findUrlRes = new ArrayList<>();

        for(Board board : boards) {
            List<Url> findUrlList = urlRepository.findUrls(board);
            findUrlRes.addAll(findUrlList);
        }

        return findUrlRes;
    }


    @Override
    @Transactional
    public void deleteUrl(Url url) {
        urlRepository.delete(url);
    }

    @Override
    @Transactional
    public void updateUrls(Board board, Collection<Url> urls) {
        // TODO: Collection이라 비교하기가 어려움. 어떤 url과 매핑할 지
    }
}
