package com.inn.cashflow.server.core.users.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inn.cashflow.server.core.users.entities.Users;
import com.inn.cashflow.server.core.users.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch the user from the database
        Users userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Map UserEntity to Spring Security's UserDetails
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword()) // The password must be hashed
                .authorities("ROLE_"+userEntity.getRoles())
                .build();
    }
}
