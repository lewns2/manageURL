package com.lewns2.backend.rest.dto.board.request;


import com.lewns2.backend.model.Board;
import com.lewns2.backend.model.Member;
import com.lewns2.backend.model.Url;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class UpdateBoardRequest {

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

    private String nickName;
    private String title;
    private String description;
    private Collection<UrlReq> urls;

    public Board toEntity(Member member) {
        return Board.builder()
                .member(member)
                .title(title)
                .description(description)
                .build();
    }

    // 서비스 레이어에서 사용할 형태로 변환 : Collection<UrlReq> -> Collection<Url>
    public Collection<Url> toEntityUrl(Board board, Collection<UpdateBoardRequest.UrlReq> urlsReq) {
        Collection<Url> newUrls = new ArrayList<>();

        for(UpdateBoardRequest.UrlReq urlReq : urlsReq) {
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
