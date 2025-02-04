package com.inn.cashflow.server.core.incomesource.enums;

public enum IncomeSourceStatus {
    ACTIVE(1),
    INACTIVE(0);

    private final int code;

    IncomeSourceStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static IncomeSourceStatus fromCode(int code) {
        for (IncomeSourceStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
