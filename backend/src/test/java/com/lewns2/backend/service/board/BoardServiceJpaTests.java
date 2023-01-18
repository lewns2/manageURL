package com.lewns2.backend.service.board;

import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Role;
import com.lewns2.backend.repository.BoardRepository;
import com.lewns2.backend.repository.MemberRepository;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootTest
public class BoardServiceJpaTests {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardService boardService;

    @Test
    void shouldSaveArticle() throws Exception {
        // given
        LocalDate createdDate = LocalDate.of(2023, 01, 18);
        LocalDate updateDate = LocalDate.of(2023, 01, 18);
        Member memberA = new Member("zlewns@gmail.com", "123", Role.USER);

        memberService.doSignUp(memberA);
        Board board = new Board(memberA, "제목", "설명", createdDate, updateDate);

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

}
