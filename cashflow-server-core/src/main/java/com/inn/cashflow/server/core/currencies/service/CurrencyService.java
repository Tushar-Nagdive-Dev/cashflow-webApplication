package com.inn.cashflow.server.core.currencies.service;

import org.springframework.http.ResponseEntity;

import com.inn.cashflow.server.core.common.responses.ApiResponse;

public interface CurrencyService {

    public ResponseEntity<ApiResponse<?>> getAvailableCurrencies() throws Exception;
}
