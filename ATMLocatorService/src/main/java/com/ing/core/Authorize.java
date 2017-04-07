package com.ing.core;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class Authorize 
{

    private static final String EXTRA_ROLE = "ROLE_EXTRA";

    public boolean checkUserHasExtraRole(final Authentication user) 
    {
        if (user != null) 
        {
            for (GrantedAuthority grantedAuthority : user.getAuthorities()) 
            {
                if (grantedAuthority.getAuthority().equals(EXTRA_ROLE)) 
                {
                    return true;
                }
            }
        }

        return false;
    }
}
