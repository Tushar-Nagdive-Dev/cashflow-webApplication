package com.inn.cashflow.server.core.currencies.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.CashFlowSystemException;
import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.currencies.entity.Currencies;
import com.inn.cashflow.server.core.currencies.repos.CurrencyRepository;
import com.inn.cashflow.server.core.currencies.service.CurrencyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepo;

    @Override
    public ResponseEntity<ApiResponse<?>> getAvailableCurrencies() throws Exception {
        log.info("Inside @class CurrencyServiceImpl @method getAvailableCurrencyCode");
        try {
            List<Currencies> currencies = currencyRepo.findAll();
            if(currencies.isEmpty()) {
                throw new CashFlowSystemException("Currencies Not found", "004");
            }

            return ResponseEntity.ok(new ApiResponse<>(true, "Successful", currencies));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
