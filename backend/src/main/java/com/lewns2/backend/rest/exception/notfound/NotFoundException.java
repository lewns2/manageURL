package com.lewns2.backend.rest.exception.notfound;

import com.lewns2.backend.rest.exception.CustomException;
import com.lewns2.backend.rest.exception.ErrorCode;


public class NotFoundException extends CustomException {

    public NotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
