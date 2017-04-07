package com.ing.controllers.web;

import static com.ing.controllers.web.MainController.INDEX_PAGE;
import static com.ing.controllers.web.MainController.USER_INDEX_PAGE;

import com.ing.core.CurrentUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityTagController 
{

    public static final String TAGS_USER_INDEX = "/tags/user/index";

    @GetMapping("/tags/index")
    public String index(@CurrentUser final User user) 
    {
        logUser(user);
        return INDEX_PAGE;
    }

    @GetMapping(TAGS_USER_INDEX)
    @Secured("ROLE_USER")
    public String userIndex(@CurrentUser final User user) 
    {
        logUser(user);
        return USER_INDEX_PAGE;
    }

    private void logUser(final User user) 
    {
        if (user != null) 
        {
            log.info("Tagged version of URL called for: " + user.getUsername());
        }
    }
}
