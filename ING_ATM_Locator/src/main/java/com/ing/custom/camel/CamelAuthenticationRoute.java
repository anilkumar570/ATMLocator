package com.ing.custom.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CamelAuthenticationRoute extends RouteBuilder {

    @Value("${authentication.route:direct:authentication-route}")
    private String authenticationRoute;

    @Autowired
    @Qualifier("authenticationProcessor")
    private Processor authProcessor;

    @Autowired
    @Qualifier("roleProcessor")
    private Processor roleProcessor;

    @Autowired
    @Qualifier("buildUserProcessor")
    private Processor buildUser;

    @Override
    public void configure() throws Exception {

        from(authenticationRoute).log(LoggingLevel.INFO, "Authenticating ... ")

                .bean(authProcessor)
                .bean(roleProcessor)
                .bean(buildUser);
    }

}
