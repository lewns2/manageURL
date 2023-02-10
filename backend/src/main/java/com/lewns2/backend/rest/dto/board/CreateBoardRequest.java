package com.lewns2.backend.rest.dto.board;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBoardRequest {

    // 게시글 작성 시, 힘께 요청보내는 URL들
    @Getter
    @NoArgsConstructor
    private static class UrlReq {
        private Board board;
        private String address;
        private String category;

        public UrlReq(String address, String category) {
            this.address = address;
            this.category = category;
        }
    }

    private String nickname;
    private String title;
    private String description;
    private List<UrlReq> urls;

    // Dto to Entity
    public Board toEntity(Member member) {

        return Board.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }

    // 서비스 레이어에서 사용할 형태로 변환 : Collection<UrlReq> -> Collection<Url>
    public Collection<Url> toEntityUrl(Board board, Collection<UrlReq> urlsReq) {
        Collection<Url> newUrls = new ArrayList<>();

        for(UrlReq urlReq : urlsReq) {
            Url url = this.toEntity(board, urlReq);
            newUrls.add(url);
        }
        return newUrls;
    }

    // UrlReq -> Url
    public Url toEntity(Board board, UrlReq urlReq) {
        return Url.builder()
                .board(board)
                .address(urlReq.address)
                .category(urlReq.category)
                .build();
    }

}
