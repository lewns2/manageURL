package com.lewns2.backend.rest.exception;

public class ExceptionResponse {

    private String message;
    private ErrorCode errorCode;

    private ExceptionResponse(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public static ExceptionResponse from(final CustomException e) {
        return new ExceptionResponse(e.getMessage(), e.getErrorCode());
    }

    // getter and setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
