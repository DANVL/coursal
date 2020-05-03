package com.lyash.certserv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.x509().subjectPrincipalRegex("CN=(.*?)(?:,|$)").
                and().authorizeRequests().anyRequest().authenticated().
                and().userDetailsService(userDetailsService());
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if (username != null) {
                return new User(username, "",
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
            }
            return null;
        };
    }
}
