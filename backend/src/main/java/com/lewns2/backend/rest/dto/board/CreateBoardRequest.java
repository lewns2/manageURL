package com.lewns2.backend.rest.dto.board;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardRequest {

    private String nickname;
    private String title;
    private String description;

    // Dto to Entity
    public Board toEntity(Member member) {

        return Board.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }
}
