package com.lewns2.backend.service.board;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.model.Url;
import com.lewns2.backend.repository.BoardRepository;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class BoardServiceJpaTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @PersistenceContext
    private EntityManager em;

//    @BeforeEach
//    public void beforeEach() {
//        clearRepository();
//        teardown();
//    }

    @AfterEach
    public void afterEach() {
        clearRepository();
        teardown();
    }

    public void teardown() {
        this.em.createNativeQuery("ALTER TABLE board AUTO_INCREMENT=1").executeUpdate();
        this.em.createNativeQuery("ALTER TABLE members AUTO_INCREMENT=1").executeUpdate();
    }

    public void clearRepository() {
        // 순서 중요
        this.em.createNativeQuery("DELETE FROM board").executeUpdate();
        this.em.createNativeQuery("DELETE FROM members").executeUpdate();
    }

    @Test
    @Transactional
    void 게시글_저장_테스트() throws Exception {
        // given
        Member memberA = new Member("zlewns@gmail.com", "123", Role.USER);
        memberService.doSignUp(memberA);

        Board board = new Board(memberA, "제목", "설명");

        // when
        boardService.doSaveArticle(board);
        Board findBoard = boardService.findBoardById(1L);

        // then
        Assertions.assertThat(findBoard.getMember().getEmail()).isEqualTo(memberA.getEmail());
        Assertions.assertThat(findBoard.getTitle()).isEqualTo(board.getTitle());
        Assertions.assertThat(findBoard.getDescription()).isEqualTo(board.getDescription());
    }

    @Test
    @Transactional
    void 특정회원_작성_게시글들_조회_테스트() throws Exception {
        // given
        Member memberA = new Member("zlewns@gmail.com", "123", Role.USER);
        memberService.doSignUp(memberA);

        Board boardA = new Board(memberA, "제목1", "설명1");
        Board boardB = new Board(memberA, "제목2", "설명2");
        boardService.doSaveArticle(boardA);
        boardService.doSaveArticle(boardB);

        // when
        Collection<Board> articles = boardService.findBoardByMemberId(1L);

        // then
        Assertions.assertThat(articles.size()).isEqualTo(2);
        Board[] articleArr = articles.toArray(new Board[articles.size()]);
        Assertions.assertThat(articleArr[0].getMember().getId()).isEqualTo(articleArr[1].getMember().getId());
    }

    @Test
    @Transactional // javax.persistence.TransactionRequiredException: Executing an update/delete query
    void 게시글_삭제_테스트() throws Exception {
        // given
        Member memberA = new Member("zlewns@gmail.com", "123", Role.USER);
        memberService.doSignUp(memberA);

        Board boardA = new Board(memberA, "제목444", "설명444");
        boardService.doSaveArticle(boardA);

        // when
        Board findBoard = this.boardService.findBoardById(1L);
        boardService.deleteArticle(findBoard);

        // then
        Assertions.assertThat(boardRepository.findByMemberId(1L)).isEmpty();
    }

}
