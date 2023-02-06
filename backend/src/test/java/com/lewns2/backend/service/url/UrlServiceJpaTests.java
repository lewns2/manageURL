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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class UrlServiceJpaTests {

    @Autowired
    MemberService memberService;

    @Autowired
    BoardService boardService;

    @Autowired
    UrlService urlService;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        clearRepository();
        teardown();
    }

    @AfterEach
    public void afterEach() {
        clearRepository();
        teardown();
    }

    public void teardown() {
        this.em.createNativeQuery("ALTER TABLE urls AUTO_INCREMENT=1").executeUpdate();
        this.em.createNativeQuery("ALTER TABLE board AUTO_INCREMENT=1").executeUpdate();
        this.em.createNativeQuery("ALTER TABLE members AUTO_INCREMENT=1").executeUpdate();
    }

    public void clearRepository() {
        // 순서 중요
        this.em.createNativeQuery("DELETE FROM urls").executeUpdate();
        this.em.createNativeQuery("DELETE FROM board").executeUpdate();
        this.em.createNativeQuery("DELETE FROM members").executeUpdate();
    }

    @Test
    @Transactional
    void URL_저장_테스트() {
        // given
        Member memberA = new Member("dh", "url@test.com", "123", Role.USER);
        memberService.doSignUp(memberA);

        Board boardA = new Board(memberA, "url-test", "url-description");
        boardService.doSaveArticle(boardA);

        List<Url> urls = new ArrayList<>();
        Url urlA = new Url(boardA, "www.url.com", "공부");
        Url urlB = new Url(boardA, "www.asd.com", "글귀");
        urls.add(urlA);
        urls.add(urlB);

        // when
        urlService.doSaveUrls(urls);
        Collection<Url> findUrls = urlService.findUrls(boardA);


        // then
        Assertions.assertThat(findUrls.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    void URL_삭제_테스트() {
        // given
        Member memberA = new Member("dh", "url@test.com", "1234", Role.USER);
        memberService.doSignUp(memberA);

        Board boardA = new Board(memberA, "url-test", "url-description");
        boardService.doSaveArticle(boardA);

        List<Url> urls = new ArrayList<>();
        Url urlA = new Url(boardA, "www.url.com", "공부");
        Url urlB = new Url(boardA, "www.asd.com", "참고글");
        urls.add(urlA);
        urls.add(urlB);
        urlService.doSaveUrls(urls);

        // when
        Collection<Url> prevResUrls = urlService.findUrls(boardA);
        Assertions.assertThat(prevResUrls.size()).isEqualTo(2);

        urlService.deleteUrl(urlA);
        Collection<Url> resUrls = urlService.findUrls(boardA);
        Url[] urlArr = resUrls.toArray(new Url[resUrls.size()]);

        // then
        Assertions.assertThat(resUrls.size()).isEqualTo(1);
        Assertions.assertThat(urlArr[0].getAddress()).isEqualTo("www.asd.com");
        Assertions.assertThat(urlArr[0].getCategory()).isEqualTo("참고글");
    }
}
