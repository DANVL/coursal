package com.lyash.basicsecurity.basicsecurity.service.impl;

import com.lyash.basicsecurity.basicsecurity.data.dao.UserDao;
import com.lyash.basicsecurity.basicsecurity.data.entity.User;
import com.lyash.basicsecurity.basicsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }
}
