package com.lyash.basicsecurity.basicsecurity.configs.security;

import com.lyash.basicsecurity.basicsecurity.configs.basic.BasicAuthenticationEntryPoint;
import com.lyash.basicsecurity.basicsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;
    private final UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public SecurityConfig(BasicAuthenticationEntryPoint basicAuthenticationEntryPoint, UserDetailsServiceImpl userDetailsService) {
        this.basicAuthenticationEntryPoint = basicAuthenticationEntryPoint;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/userinfo").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/admininfo").hasRole("ADMIN")
                .and()
                .formLogin();
    }



}
