package com.inn.cashflow.server.core.taxes.enums;

public enum TaxRecordStatus {
    PAID(0),       // Ordinal 0
    PENDING(1),    // Ordinal 1
    OVERDUE(2);    // Ordinal 2

    private final int code;

    TaxRecordStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TaxRecordStatus fromCode(int code) {
        for (TaxRecordStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
