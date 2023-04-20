package com.github.godwinpinto.authable.infrastructure.crypto.service;

import com.github.godwinpinto.authable.commons.constants.ApplicationConstants;
import com.github.godwinpinto.authable.domain.auth.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JWTUtilService {

    @Value("${infrastructure-crypto.jwt.secret}")
    private String secret;

    @Value("${infrastructure-crypto.jwt.expiry}")
    private String expirationTime;

    private Key key;

    @PostConstruct
    public void init() {
        if (secret.length() < 64) {
            throw new JwtException("Your JWT Key is Less than 64 characters");
        }
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDto userDto) {

        if (userDto == null || userDto.getUsername() == null || userDto.getSystemId() == null || userDto.getRoles() == null) {
            throw new JwtException("Error in creating JWT because all fields are not supplied");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put(ApplicationConstants.JWT_ROLE_KEY, userDto.getRoles());
        claims.put(ApplicationConstants.JWT_SYSTEM_ID_KEY, userDto.getSystemId());
        return doGenerateToken(claims, userDto.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        Long expirationTimeLong = Long.parseLong(expirationTime); //in second
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    public List<String> rolesFromClaim(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.get(ApplicationConstants.JWT_ROLE_KEY, List.class);
    }

}
