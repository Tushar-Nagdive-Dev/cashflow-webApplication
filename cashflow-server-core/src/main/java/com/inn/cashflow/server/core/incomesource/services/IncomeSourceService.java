package com.inn.cashflow.server.core.incomesource.services;

import org.springframework.http.ResponseEntity;

import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.incomesource.dto.AddIncomeDTO;
import com.inn.cashflow.server.core.incomesource.enums.IncomeSourceStatus;

public interface IncomeSourceService {
    
    public ResponseEntity<ApiResponse<?>> getIncomeSourceByStatus(IncomeSourceStatus status)throws Exception;

    public ResponseEntity<ApiResponse<?>> addIncomeSource(AddIncomeDTO incomeDTO) throws Exception;
}
