package com.lewns2.backend.rest.exception.badrequest;

import com.lewns2.backend.rest.exception.ErrorCode;

import static com.lewns2.backend.rest.exception.ErrorCode.INVALID_PASSWORD_PARAM;

public class InvalidPasswordException extends InvalidValueException{

    public InvalidPasswordException() {
        super(INVALID_PASSWORD_PARAM, "비밀번호가 일치하지 않습니다.");
    }
}
