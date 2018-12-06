package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Collections;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ConferenceController.class)
public class ConferenceControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ConferenceController conferenceController;

    @MockBean
    private ConferenceService conferenceService;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        MockitoAnnotations.initMocks(this);
        mockMvc =
                MockMvcBuilders
                        .standaloneSetup(conferenceController)
                        .setViewResolvers(viewResolver)
                        .build();
    }

    @Test
    public void showNewConferencePage_ShouldCreateNeConferenceAndRenderNewConferencePage() throws Exception {
        Conference testConference = new Conference();

        given(conferenceService.createNewConference()).willReturn(testConference);

        mockMvc.perform(get("/new-conference"))
                .andExpect(status().isOk())
                .andExpect(view().name("new-conference"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/new-conference.jsp"))
                .andExpect(model().attributeExists("conference"))
                .andExpect(model().attribute("conference", is(testConference)));
    }

    @Test
    public void addConference_ShouldAddNewConferenceAndRedirectToSchedule() throws Exception {
        Conference testConference = new Conference();

        mockMvc.perform(post("/new-conference")
                .param("conferenceTitle", "testConferenceTitle"))
                .andExpect(view().name("redirect:" + "/schedule"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isFound());
    }

    @Test
    public void showConferenceInfo_ShouldRenderConferencePage() throws Exception {
        Conference testConference = new Conference();
        testConference.setConferenceTeams(Collections.emptyList());
        int testConferenceId = 3;

        given(conferenceService.getConferenceById(testConferenceId)).willReturn(testConference);

        mockMvc.perform(get("/conference?id=" + testConferenceId))
                .andExpect(view().name("conference"))
                .andExpect(model().attributeExists("conferenceAttribute"))
                .andExpect(model().attribute("conferenceAttribute", is(testConference)))
                .andExpect(status().isOk());
    }

}