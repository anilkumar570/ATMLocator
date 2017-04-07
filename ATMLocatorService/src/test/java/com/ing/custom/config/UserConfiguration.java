package com.ing.custom.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserConfiguration 
{

    @Bean
    public UserDetailsService userDetails() 
    {
        return username -> {

            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + username.toUpperCase());
            UserDetails userDetails = new User(username, username + "123", Arrays.asList(authority));
            return userDetails;
        };
    }

}
