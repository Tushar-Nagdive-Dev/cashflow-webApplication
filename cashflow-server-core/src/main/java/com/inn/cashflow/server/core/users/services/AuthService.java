package com.inn.cashflow.server.core.users.services;

import org.springframework.http.ResponseEntity;

import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.users.dto.AuthRequestDTO;
import com.inn.cashflow.server.core.users.dto.RegisterRequestDTO;

public interface AuthService {
    
    public ResponseEntity<String> registerUser(RegisterRequestDTO resterRequest);

    public ResponseEntity<ApiResponse<?>> loginUser(AuthRequestDTO request);
}
