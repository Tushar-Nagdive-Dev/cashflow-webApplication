package com.inn.cashflow.server.core.baseimpl.aopimpl.exceptions.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp;

    private String message;

    private String errorCode;

    private String path;
}
