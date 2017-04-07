package com.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class ATMLocator 
{
    public static void main(final String[] args) throws Exception 
    {
        SpringApplication.run(ATMLocator.class, args);
    }

    @Bean
    EmbeddedServletContainerCustomizer containerCustomizer() 
    {
        return container -> 
        {
            container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        };
    }
}
