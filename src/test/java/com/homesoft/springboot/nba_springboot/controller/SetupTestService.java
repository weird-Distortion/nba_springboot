package com.homesoft.springboot.nba_springboot.controller;

import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class SetupTestService {

    public MockMvc defaultSetup(Object object, MockMvc mockMvc, NbaController controller) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        MockitoAnnotations.initMocks(object);
        mockMvc =
                MockMvcBuilders
                        .standaloneSetup(controller)
                        .setViewResolvers(viewResolver)
                        .build();

        return mockMvc;
    }
}
