package com.inn.cashflow.server.core.incomesource.dto;

import java.math.BigDecimal;

import com.inn.cashflow.server.core.incomesource.enums.IncomeSourceStatus;

public record AddIncomeDTO(
    String sourceName,
    String sourceType,
    BigDecimal amount,
    String currency,
    String frequency,
    String description,
    IncomeSourceStatus status
) {}
