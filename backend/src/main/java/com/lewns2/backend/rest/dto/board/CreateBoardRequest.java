package com.lewns2.backend.rest.dto.board;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CreateBoardRequest {

    private Member member;
    private String title;
    private String description;

    // Dto to Entity
    public Board toEntity() {
        return Board.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }
}
