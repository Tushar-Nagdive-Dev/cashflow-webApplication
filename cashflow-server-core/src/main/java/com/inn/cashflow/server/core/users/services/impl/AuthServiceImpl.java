package com.inn.cashflow.server.core.users.services.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inn.cashflow.server.core.baseimpl.config.JwtTokenUtil;
import com.inn.cashflow.server.core.common.responses.ApiResponse;
import com.inn.cashflow.server.core.users.dto.AuthRequestDTO;
import com.inn.cashflow.server.core.users.dto.RegisterRequestDTO;
import com.inn.cashflow.server.core.users.entities.Users;
import com.inn.cashflow.server.core.users.repository.UserRepository;
import com.inn.cashflow.server.core.users.services.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseEntity<String> registerUser(RegisterRequestDTO registerRequest) {
        // Check if username or email is already taken
        if (userRepository.findByUsername(registerRequest.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        if (userRepository.findByEmail(registerRequest.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Assign a default role if not provided
        String role = registerRequest.roles().isEmpty() ? "USER" : registerRequest.roles().iterator().next();

        // Create a new user
        Users newUser = new Users();
        newUser.setFirstName(registerRequest.firstName());
        newUser.setLastName(registerRequest.lastName());
        newUser.setUsername(registerRequest.username());
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(passwordEncoder.encode(registerRequest.password())); // Encrypt password
        newUser.setRoles(role);// Assign single role

        newUser = userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully!");
    }

    @Override
    public ResponseEntity<ApiResponse<?>> loginUser(AuthRequestDTO request) {
        // Authenticate the user; this will throw an exception if authentication fails
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        // Fetch the user from the database
        Users user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate and return the JWT token
        String token = jwtTokenUtil.generateToken(user.getUsername(), Set.of(user.getRoles()));
        if(token != null && !token.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Login successful", Map.of("token", token)));
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse<>(false, "Invalid credentials", "Unauthorized"));
        }
    }

    
}
