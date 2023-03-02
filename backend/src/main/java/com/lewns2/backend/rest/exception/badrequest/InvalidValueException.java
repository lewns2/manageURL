package com.lewns2.backend.rest.exception.badrequest;

import com.lewns2.backend.rest.exception.CustomException;
import com.lewns2.backend.rest.exception.ErrorCode;

public class InvalidValueException extends CustomException {

    public InvalidValueException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
