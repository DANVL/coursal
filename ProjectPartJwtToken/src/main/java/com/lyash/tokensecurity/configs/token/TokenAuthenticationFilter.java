package com.lyash.tokensecurity.configs.token;

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

public class TokenAuthenticationFilter extends OncePerRequestFilter {


    private final TokenProvider tokenProvider;

    @Autowired
    public TokenAuthenticationFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwtToken = getToken(httpServletRequest);
            if (StringUtils.hasText(jwtToken) && tokenProvider.validateToken(jwtToken)) {
                authenticationValidation(jwtToken);
            }
        } catch (Exception ex) {
            System.err.println("Could not set authentication in context: " + ex);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void authenticationValidation(String jwtToken) {
        Authentication authentication = tokenProvider.getAuth(jwtToken);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token.startsWith("Bearer ")
                && StringUtils.hasText(token)) {
            return token.substring(7);
        }
        return null;
    }
}
