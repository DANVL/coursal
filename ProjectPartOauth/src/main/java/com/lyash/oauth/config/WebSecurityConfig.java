package com.lyash.oauth.config;

import com.lyash.oauth.data.entity.Role;
import com.lyash.oauth.data.entity.User;
import com.lyash.oauth.data.repository.UserDetailsRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/userinfo").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/admininfo").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserDetailsRepository userDetailsRepository){
        return map  ->
        {
            String id = String.valueOf(map.get("sub"));
            User user = userDetailsRepository.findById(id)
                    .orElseGet(() -> {
                User newUser = new User();

                newUser.setId(id);
                newUser.setName(String.valueOf(map.get("name")));
                newUser.setEmail(String.valueOf(map.get("email")));
                newUser.setGender(String.valueOf(map.get("gender")));
                newUser.setLocale(String.valueOf(map.get("locale")));
                newUser.setUserpic(String.valueOf(map.get("picture")));
                newUser.setRole(Role.ROLE_USER);

                return newUser;
            });

            return userDetailsRepository.save(user);
        };
    }

}
