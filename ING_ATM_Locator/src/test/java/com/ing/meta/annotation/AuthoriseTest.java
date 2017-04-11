package com.ing.meta.annotation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.ing.ATMLocator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ATMLocator.class)
@WebAppConfiguration
public class AuthoriseTest {

    @Autowired
    private Authorize authorise;

    @Test
    public void whenNoUser_thenExtraRole_resultFalse() {
        assertFalse(authorise.checkUserHasExtraRole(null));
    }

    @Test
    public void whenUserHasUserRole_thenExtraRole_resultFalse() {
        Authentication authentication = new TestingAuthenticationToken("user", "pw", "ROLE_USER");
        assertFalse(authorise.checkUserHasExtraRole(authentication));
    }

    @Test
    public void whenUserHasExtraRole_thenExtraRole_resultTrue() {
        Authentication authentication = new TestingAuthenticationToken("user", "pw", "ROLE_EXTRA");
        assertTrue(authorise.checkUserHasExtraRole(authentication));
    }
}
