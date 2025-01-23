package com.inn.cashflow.server.core.incomesource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.incomesource.dto.AddIncomeDTO;
import com.inn.cashflow.server.core.incomesource.enums.IncomeSourceStatus;
import com.inn.cashflow.server.core.incomesource.services.IncomeSourceService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/income-source")
public class IncomeSourceController {

    private final IncomeSourceService service;
    
    @GetMapping("/active")
    public ResponseEntity<ApiResponse<?>> getMethodName(@RequestParam IncomeSourceStatus status) throws Exception {
        return service.getIncomeSourceByStatus(status);
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<?>> postMethodName(@RequestBody AddIncomeDTO incomeDTO) throws Exception {
        return service.addIncomeSource(incomeDTO);
    }
    
}
