package com.lyash.tokensecurity.services;

import com.lyash.tokensecurity.data.entity.User;
import org.springframework.security.core.Authentication;

public interface TokenService {
    String tokenProvider(User user);

}
