package com.ing.custom.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.ing.ATMLocator;
import com.ing.web.MainController;
import com.ing.web.SecurityTagController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ATMLocator.class)
@WebAppConfiguration
public class SecurityTagControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private SecurityTagController controller;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }   

    @Test
    @WithUserDetails("user")
    public void whenUserPage_withNormalUser_thenSuccess() throws Exception {
        mockMvc.perform(get(SecurityTagController.TAGS_USER_INDEX)).andExpect(status().isOk());
    }
    
    @Test
    public void thatLoginPageReturned() throws Exception {
        generalPageTest("/tags/index", MainController.INDEX_PAGE);
    }

    private void generalPageTest(final String url, final String page) throws Exception {
        mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(view().name(page));
    }

    // tests the logging method
    @Test
    public void whenNullUser_thenLogUser_isOK() {
        controller.index(null);
    }
}
