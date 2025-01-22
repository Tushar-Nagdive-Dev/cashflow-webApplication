package com.inn.cashflow.server.core.baseimpl.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil {

    private final SecretKey SECRET_KEY;
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public JwtTokenUtil() {
        // Fetching the JWT_SECRET from environment variable
        String secret = "7oQE7mkoqdfPGnYU4QSC+dQx9NyXubWXRsJ/9uiOHrs1fNFCKBjqbstNSKEef3m6nWoV8bdYPgQmqIw2R/Umpg==";
        if (secret == null || secret.isEmpty()) {
            throw new IllegalStateException("JWT_SECRET environment variable must be set");
        }

        // Decode the base64-encoded string into a secret key
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        this.SECRET_KEY = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Generate a JWT token for the given username and roles.
     *
     * @param username the username
     * @param roles    the roles of the user
     * @return the generated JWT token as a String
     */
    public String generateToken(String username, Set<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    /**
     * Parse and extract claims from the given token.
     *
     * @param token the JWT token
     * @return the claims extracted from the token
     */
    public Claims getClaims(String token) {
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    /**
     * Validate the given token by checking its signature and expiration.
     *
     * @param token    the JWT token
     * @param username the username to validate against
     * @return true if the token is valid, false otherwise
     */
    public boolean isTokenValid(String token, String username) {
        String tokenUsername = getClaims(token).getSubject();
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * Check if the given token is expired.
     *
     * @param token the JWT token
     * @return true if the token is expired, false otherwise
     */
    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
