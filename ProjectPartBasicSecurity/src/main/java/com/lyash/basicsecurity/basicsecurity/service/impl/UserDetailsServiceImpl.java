package com.lyash.basicsecurity.basicsecurity.service.impl;

import com.lyash.basicsecurity.basicsecurity.configs.basic.BasicUser;
import com.lyash.basicsecurity.basicsecurity.data.entity.User;
import com.lyash.basicsecurity.basicsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUser(s);

        return new BasicUser(user.getUsername(),
                (user.getPassword()), new ArrayList<>() {{
            add(new SimpleGrantedAuthority(user.getRole().toString()));
        }});
    }
}
