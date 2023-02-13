package com.lewns2.backend.service;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;


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
    public Collection<Url> findUrls(Board board) {
        return urlRepository.findUrls(board);
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
