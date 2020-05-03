package com.lyash.tokensecurity.data.dao.impl;

import com.lyash.tokensecurity.data.dao.UserDao;
import com.lyash.tokensecurity.data.entity.Role;
import com.lyash.tokensecurity.data.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String username) {
        if(username.equals("admin")){
            return new User(
                    "1","admin",new BCryptPasswordEncoder().encode("password"),
                    "email", Role.ROLE_ADMIN);
        }else if(username.equals("user")){
            return new User(
                    "1","user",new BCryptPasswordEncoder().encode("password"),
                    "email", Role.ROLE_USER);
        }
        return null;
    }

    @Override
    public User getUser(String username, String password) {
        if(username.equals("admin") && password.equals("password")){
            return new User(
                    "1","admin","pasword",
                    "email", Role.ROLE_ADMIN);
        }else if(username.equals("user") && password.equals("password")){
            return new User(
                    "1","user","pasword",
                    "email", Role.ROLE_USER);
        }
        return null;
    }
}
