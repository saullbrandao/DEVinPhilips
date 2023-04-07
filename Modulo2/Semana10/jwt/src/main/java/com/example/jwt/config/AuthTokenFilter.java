package com.example.jwt.config;

import com.example.jwt.model.User;
import com.example.jwt.repository.UserRepository;
import com.example.jwt.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserDetailsImpl userDetails;

    public AuthTokenFilter(TokenService tokenService, UserDetailsImpl userDetails) {
        this.tokenService = tokenService;
        this.userDetails = userDetails;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(request);
        Boolean isValid = tokenService.isTokenValid(token);

        if (isValid) authenticateClient(token);

        filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        String usename = tokenService.getUsername(token);
        User user = (User) userDetails.loadUserByUsername(usename);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isBlank() || !token.startsWith("Bearer")) return null;

        return token.substring(7);
    }
}
