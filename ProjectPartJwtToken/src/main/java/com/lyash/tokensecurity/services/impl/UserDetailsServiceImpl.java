package com.lyash.tokensecurity.services.impl;

import com.lyash.tokensecurity.configs.jwt.JwtUser;
import com.lyash.tokensecurity.data.entity.User;
import com.lyash.tokensecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser(s);
        return new JwtUser(user, new ArrayList<>() {{
            add(new SimpleGrantedAuthority(user.getRole().toString()));
        }});
    }
}
