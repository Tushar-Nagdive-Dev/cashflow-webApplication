package com.inn.cashflow.server.core.baseimpl.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil {

    private final String SECRET_KEY = "CASH983457362FL983OWNHS23190472B"; // Use a strong secret key
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(String username, Set<String> roles) {
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // Use the correct byte format for the key
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey, SignatureAlgorithm.HS512) // Pass the key and algorithm
                .compact();
    }

    public Claims getClaims(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(secretKey) // Set the key for parsing
                .build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, String username) {
        final String tokenUsername = getClaims(token).getSubject();
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
