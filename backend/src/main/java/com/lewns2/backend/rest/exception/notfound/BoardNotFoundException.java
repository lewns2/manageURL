package com.lewns2.backend.rest.exception.notfound;

import com.lewns2.backend.rest.exception.ErrorCode;

public class BoardNotFoundException extends NotFoundException{

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND, "해당 게시글을 찾을 수 없습니다.");
    }
}
