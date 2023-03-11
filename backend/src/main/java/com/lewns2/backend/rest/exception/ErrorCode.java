package com.lewns2.backend.rest.exception;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
    //
    INVALID_PASSWORD_PARAM("400"),

    //
    MEMBER_NOT_FOUND("404"),
    BOARD_NOT_FOUND("404");


    private final String value;

    ErrorCode(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
