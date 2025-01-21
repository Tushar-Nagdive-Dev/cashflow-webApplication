package com.inn.cashflow.server.core.baseimpl.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil {

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Secure key generation
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    /**
     * Generate JWT token for the given username and roles.
     *
     * @param username the username
     * @param roles    the user roles
     * @return the generated token
     */
    public String generateToken(String username, Set<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512) // Use the generated secure key
                .compact();
    }

    /**
     * Parse and retrieve claims from the token.
     *
     * @param token the JWT token
     * @return the claims
     */
    public Claims getClaims(String token) {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Use the same key for parsing
                .build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    /**
     * Validate the token against username and expiration.
     *
     * @param token    the JWT token
     * @param username the username
     * @return true if valid, false otherwise
     */
    public boolean isTokenValid(String token, String username) {
        final String tokenUsername = getClaims(token).getSubject();
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * Check if the token is expired.
     *
     * @param token the JWT token
     * @return true if expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
