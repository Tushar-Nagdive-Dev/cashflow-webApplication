package com.inn.cashflow.server.core.users.dto;

import java.util.Set;

public record RegisterRequestDTO(
    String firstName,
    String lastName,
    String username,
    String password,
    String email,
    Set<String> roles
) {}
