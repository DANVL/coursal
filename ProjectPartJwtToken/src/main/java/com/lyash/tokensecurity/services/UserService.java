package com.lyash.tokensecurity.services;

import com.lyash.tokensecurity.data.entity.User;

public interface UserService {
    User getUser(String username, String password);

    User getUser(String username);
}
