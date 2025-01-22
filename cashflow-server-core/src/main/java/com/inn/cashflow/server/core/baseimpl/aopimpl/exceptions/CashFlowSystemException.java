package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions;

public class CashFlowSystemException extends RuntimeException {
    
    private final String errorCode;

    public CashFlowSystemException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
