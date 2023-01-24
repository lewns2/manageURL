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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void 게시글저장_URL없이_테스트() throws Exception {
        // given
//        LocalDate createdDate = LocalDate.of(2023, 01, 18);
//        LocalDate updateDate = LocalDate.of(2023, 01, 18);
        Member memberA = new Member("zlewns@gmail.com", "123", Role.USER);

        memberService.doSignUp(memberA);
        Board board = new Board(memberA, "제목", "설명");

        // when
        boardService.doSaveArticle(board);

        // then
    }

    @Test
    void shouldFindBoardByMemberId() throws Exception {
        Collection<Board> boards = this.boardService.findBoardByMemberId(15L);
        Assertions.assertThat(boards.size()).isEqualTo(1);
        Board[] boardArr = boards.toArray(new Board[boards.size()]);
        Assertions.assertThat(boardArr[0].getMember()).isNotNull();
    }

    @Test
    void shouldDeleteBoard() throws Exception {
        Board boardA = boardRepository.findById(4L);
        boardService.deleteArticle(boardA);
        try {
            boardA = boardService.findBoardById(4L);
        } catch (Exception e) {
            boardA = null;
        }
        Assertions.assertThat(boardA).isNull();

    }

}
