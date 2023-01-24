package com.lewns2.backend.service.url;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.UrlRepository;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import com.lewns2.backend.service.UrlService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UrlServiceJpaTests {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @Autowired
    UrlService urlService;

    @Test
    void URL저장_테스트() {
        // given
        Member memberA = new Member("url@test.com", "123", Role.USER);

        Board boardA = new Board(memberA, "url-test", "url-description");

        List<Url> urls = new ArrayList<>();
        Url urlA = new Url(boardA, "www.url.com", "공부");
        Url urlB = new Url(boardA, "www.asd.com", "글귀");
        urls.add(urlA);
        urls.add(urlB);

        memberService.doSignUp(memberA);
        boardService.doSaveArticle(boardA);

        // when

        urlService.doSaveUrls(urls);

        // then


    }
}
