package com.ing.custom.simple;

import java.util.Collection;
import java.util.HashSet;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("roleProcessor")
public class SimpleRoleProcessor implements Processor {

    private static final String ROLE_USER = "ROLE_USER";

    private static final String ROLES = "roles";

    @Override
    public void process(final Exchange exchange) throws Exception {
        Authentication body = exchange.getIn().getBody(Authentication.class);

        Collection<GrantedAuthority> roles = new HashSet<>(body.getAuthorities());

        roles.add(new SimpleGrantedAuthority(ROLE_USER));

        exchange.getIn().setHeader(ROLES, roles);
    }

}
