package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions;

import com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.enums.ErrorCode;

public class CashFlowSystemException extends RuntimeException {
    
    private final String errorCode;

    // Constructor using ErrorCode enum
    public CashFlowSystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
    }

    // Constructor using ErrorCode enum with a custom message
    public CashFlowSystemException(ErrorCode errorCode, String customMessage) {
        super(customMessage);
        this.errorCode = errorCode.getCode();
    }

    public CashFlowSystemException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
