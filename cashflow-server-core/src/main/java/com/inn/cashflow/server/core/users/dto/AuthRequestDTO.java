package com.inn.cashflow.server.core.users.dto;

public record AuthRequestDTO(
    String username,
    String password
) {}
