package com.inn.cashflow.server.core.currencies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.currencies.service.CurrencyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency")
public class CurrencyController {
    
    private final CurrencyService currencyService;

    @GetMapping("/codes")
    public ResponseEntity<ApiResponse<?>> getAvailableCurrencyCode() throws Exception {
        log.info("Inside @class CurrencyController @method getAvailableCurrencyCode");
        return currencyService.getAvailableCurrencies();
    }
    
}
