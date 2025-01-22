package com.inn.cashflow.server.core.baseimpl;

import java.util.Base64;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class SecretKeyGenerator {
    
    public static void main(String[] args) {
        // Generate a secure 64-byte key
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        // Encode it to Base64 if you need the string representation
        String base64Secret = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Print the generated Base64 secret
        System.out.println("Generated 64-byte Base64 secret: " + base64Secret);
    }
}
