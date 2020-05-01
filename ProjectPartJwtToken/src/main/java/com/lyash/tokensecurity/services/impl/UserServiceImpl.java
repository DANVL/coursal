package com.lyash.tokensecurity.services.impl;

import com.lyash.tokensecurity.data.dao.UserDao;
import com.lyash.tokensecurity.data.entity.Role;
import com.lyash.tokensecurity.data.entity.User;
import com.lyash.tokensecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String username, String password) {
        return userDao.getUser(username,password);
    }

    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }
}
