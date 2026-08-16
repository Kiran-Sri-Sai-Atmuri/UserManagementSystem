package com.kiran.UserManagementSystem.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
@Component
public class JwtUtil {
    private String SECRET_KEY = "abcd1234efghijkiran@$%^*1234dfghj789tyui23vbnmkio";
    private SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final Long expiration = 10000*60*60L;
    public String generateToken(String userName) {
        return Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(key)
                .compact();
    }

    public String extractUserName(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean verifyToken(String username, UserDetails userDetails, String token) {
        return username.equals(userDetails.getUsername()) && isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().after(new Date());
    }
}
