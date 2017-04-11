package com.ing.custom;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.ing.ATMLocator;
import com.ing.error.CustomErrorController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ATMLocator.class)
@WebAppConfiguration
public class CustomErrorControllerTest {

    @Autowired
    private CustomErrorController controller;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void thatErrorPathIsNotNull() {
        assertNotNull(controller.getErrorPath());
    }

    @Test
    public void pageNotFound() throws Exception {
        mockMvc.perform(get("/notThere")).andExpect(status().is4xxClientError());

    }

    @Test
    public void errorPage() throws Exception {
        mockMvc.perform(get("/error")).andExpect(status().isOk())
                .andExpect(view().name(CustomErrorController.ERROR_VIEW_NAME));

    }

    @Test
    public void unauthorisedPage() throws Exception {
        mockMvc.perform(get("/403")).andExpect(status().isOk())
                .andExpect(view().name(CustomErrorController.UNAUTHORISED_VIEW_NAME));

    }
}
