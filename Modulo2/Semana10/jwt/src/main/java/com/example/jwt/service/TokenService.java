package com.example.jwt.service;

import com.example.jwt.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${security.jwt.expiration}")
    private Long expireTime;

    @Value("${security.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Date today = new Date();
        Date expireDate = new Date();
        expireDate.setTime(today.getTime() + expireTime);
        System.out.println(secret);
        System.out.println(expireTime);

        return Jwts.builder()
                .setIssuer("Security JWT")
                .setSubject(String.valueOf(user.getUsername()))
                .setIssuedAt(today)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
