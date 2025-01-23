package com.inn.cashflow.server.core.incomesource.services.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.CashFlowSystemException;
import com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.enums.ErrorCode;
import com.inn.cashflow.server.core.baseimpl.config.UserContext;
import com.inn.cashflow.server.core.common.Constants.CommonConstants;
import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.incomesource.dto.AddIncomeDTO;
import com.inn.cashflow.server.core.incomesource.entity.IncomeSource;
import com.inn.cashflow.server.core.incomesource.enums.IncomeSourceStatus;
import com.inn.cashflow.server.core.incomesource.repository.IncomeRepository;
import com.inn.cashflow.server.core.incomesource.services.IncomeSourceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class IncomeSourceServiceImpl implements IncomeSourceService{

    private final IncomeRepository repo;

    @Override
    public ResponseEntity<ApiResponse<?>> getIncomeSourceByStatus(IncomeSourceStatus status) throws Exception{
        log.info("Inside @class IncomeSourceServiceImpl @method getIncomeSourceByStatus status : {}", status);
        try {
            List<IncomeSource> sources = repo.findByStatus(status);
            return ResponseEntity.ok(new ApiResponse<>(true, CommonConstants.SUCCESS_MESSAGE, sources));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity<ApiResponse<?>> addIncomeSource(AddIncomeDTO incomeDTO) throws Exception {
        log.info("Inside @class IncomeSourceServiceImpl @method addIncomeSource incomeDTO :: {}", incomeDTO.toString());
        try {
            if(repo.existsBySourceName(incomeDTO.sourceName().trim())) {
                throw new CashFlowSystemException(ErrorCode.INCOME_SOURCE_ALREADY_EXISTS);
            }

            if(incomeDTO.sourceType().isEmpty()) {
                throw new CashFlowSystemException(ErrorCode.INCOME_SOURCE_TYPE_NOT_EMPTY);
            }

            IncomeSource incomeSource = new IncomeSource();
            incomeSource.setUserId(UserContext.getCurrentUser().getId());
            incomeSource.setAmount(incomeDTO.amount());
            incomeSource.setCurrency(incomeDTO.currency());
            incomeSource.setDescription(incomeDTO.description());
            incomeSource.setFrequency(incomeDTO.frequency());
            incomeSource.setSourceName(incomeDTO.sourceName());
            incomeSource.setSourceType(incomeDTO.sourceType());
            incomeSource.setStatus(incomeDTO.status());

            incomeSource = repo.save(incomeSource);

            return ResponseEntity.ok(new ApiResponse<>(true, CommonConstants.SUCCESS_MESSAGE, incomeSource));
        } catch (Exception e) {
            throw new CashFlowSystemException(e.getMessage(), CommonConstants.ERROR_CODE_GENERIC);
        }
    }
    
}
