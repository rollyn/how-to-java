package com.wisphil.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

import static com.wisphil.constant.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;

@Component
public class JwtTokenUtil implements Serializable {

    @Value("${jwt.security.key}")
    private String jwtKey;

    public String generateToken(UserDetails userDetails) {
        return doGenerateToken(userDetails.getUsername());
    }

    public String doGenerateToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://wisphil.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +           
                          ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, jwtKey)
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final Claims claims = getAllClaimsFromToken(token);
        return (
                claims.getSubject().equals(userDetails.getUsername())
                        && !claims.getExpiration().before(new Date()));
    }

}