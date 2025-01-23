package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.enums;

public enum ErrorCode {

    USER_NOT_FOUND("001", "User not found"),
    INCOME_SOURCE_ALREADY_EXISTS("006", "Source name already exists, do you want to update the amount?"),
    OPERATION_FAILED("009", "Operation failed"),
    INCOME_SOURCE_TYPE_NOT_EMPTY("010", "Income Source Type Can't Be EMPTY");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
