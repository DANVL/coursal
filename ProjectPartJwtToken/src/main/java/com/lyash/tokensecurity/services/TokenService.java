package com.lyash.tokensecurity.services;

import com.lyash.tokensecurity.data.entity.User;

public interface TokenService {
    String tokenProvider(User user);

}
