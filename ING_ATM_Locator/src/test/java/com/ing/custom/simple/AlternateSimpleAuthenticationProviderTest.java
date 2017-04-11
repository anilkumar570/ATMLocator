package com.ing.custom.simple;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AlternateSimpleAuthenticationProviderTest {

    private static final String USERNAME = "second";
    private static final String PASSWORD = "second";
    private static final String BAD_USERNAME = "wrong";

    private AlternateSimpleAuthenticationProvider provider;

    @Before
    public void setUp() {
        provider = new AlternateSimpleAuthenticationProvider();
    }

    @Test
    public void happyPath() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(USERNAME, PASSWORD);
        Authentication authenticate = provider.authenticate(token);
        assertTrue(authenticate == token);
    }

    @Test(expected = org.springframework.security.core.AuthenticationException.class)
    public void testBadUsername() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(BAD_USERNAME, PASSWORD);
        provider.authenticate(token);
        fail();
    }

    @Test
    public void whenSupportsWithCorrectClassThenTrue() {
        assertTrue(provider.supports(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    public void whenSupportsWithIncorrectClassThenFalse() {
        assertFalse((provider.supports(String.class)));
    }

}
