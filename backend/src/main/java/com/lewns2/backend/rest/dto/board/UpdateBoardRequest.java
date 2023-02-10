package com.lewns2.backend.rest.dto.board;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.Update;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBoardRequest {

    private String nickName;
    private String title;
    private String description;

    public UpdateBoardRequest(String nickName) {
        this.nickName = nickName;
    }

    public Board toEntity(Member member) {
        return Board.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }
}
