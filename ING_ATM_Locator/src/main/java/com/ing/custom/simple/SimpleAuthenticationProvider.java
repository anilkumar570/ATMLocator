package com.ing.custom.simple;

import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Profile("default")
@Component("camelRouteAuthenticationProvider")
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    private static final String BAD_USER = "error";
    private static final String BAD_PASSWORD = "error";

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

        if (BAD_USER.equalsIgnoreCase(authentication.getName())
                || BAD_PASSWORD.equalsIgnoreCase(authentication.getCredentials().toString())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return authentication;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
