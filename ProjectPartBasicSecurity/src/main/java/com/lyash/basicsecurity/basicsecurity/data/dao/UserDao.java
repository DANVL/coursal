package com.lyash.basicsecurity.basicsecurity.data.dao;

import com.lyash.basicsecurity.basicsecurity.data.entity.User;


public interface UserDao {

    User getUser(String username);

    User getUser(String username, String password);
}
