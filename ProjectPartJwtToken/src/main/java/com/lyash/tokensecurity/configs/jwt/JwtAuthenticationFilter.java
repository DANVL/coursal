package com.lyash.tokensecurity.configs.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final TokenProvider tokenProvider;

    @Autowired
    public JwtAuthenticationFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwtToken = getJWTFromRequest(httpServletRequest);
            if (StringUtils.hasText(jwtToken) && tokenProvider.validateToken(jwtToken)) {
                insideValidation(jwtToken);
            }
        } catch (Exception ex) {
            System.err.println("Could not set authentication in context: "+ex);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void insideValidation(String jwtToken) {
        String usernameFromJwt = tokenProvider.getUsernameFromJwt(jwtToken);

        if (StringUtils.isEmpty(usernameFromJwt)) {
            throw new UsernameNotFoundException("Username from JWT not found");
        }

        Authentication authentication = tokenProvider.getAuthentication(jwtToken);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
