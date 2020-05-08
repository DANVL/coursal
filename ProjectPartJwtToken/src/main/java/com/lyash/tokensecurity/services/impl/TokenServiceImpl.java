package com.lyash.tokensecurity.services.impl;

import com.lyash.tokensecurity.configs.token.TokenProvider;
import com.lyash.tokensecurity.data.entity.User;
import com.lyash.tokensecurity.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public String tokenProvider(User user) {
        return tokenProvider.provideToken(user);
    }
}
