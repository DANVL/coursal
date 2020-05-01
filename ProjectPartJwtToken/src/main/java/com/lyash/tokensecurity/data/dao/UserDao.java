package com.lyash.tokensecurity.data.dao;

import com.lyash.tokensecurity.data.entity.User;

public interface UserDao {

    User getUser(String username);

    User getUser(String username, String password);
}
