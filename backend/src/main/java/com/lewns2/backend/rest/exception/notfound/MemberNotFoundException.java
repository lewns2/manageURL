package com.lewns2.backend.rest.exception.notfound;

import com.lewns2.backend.rest.exception.ErrorCode;


public class MemberNotFoundException extends NotFoundException {

    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND, "회원을 찾을 수 없습니다.");
    }
}
