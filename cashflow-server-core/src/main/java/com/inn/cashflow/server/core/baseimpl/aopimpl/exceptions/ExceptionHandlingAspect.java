package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.model.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {
    
    @AfterThrowing(pointcut = "execution(* com.inn.cashflow.server.core..*(..))", throwing = "exception")
    public ResponseEntity<ErrorResponse> handleException(CashFlowSystemException exception, HttpServletRequest request) {
        // Log exception details
        log.error("Exception caught in AOP: {} - {}", exception.getErrorCode(), exception.getMessage());

        // Prepare error response
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                exception.getErrorCode(),
                request.getRequestURI()
        );

        // Return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
