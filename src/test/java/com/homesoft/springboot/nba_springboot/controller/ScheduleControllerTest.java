package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.RegularSeason;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ScheduleController.class)
public class ScheduleControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ScheduleController scheduleController;

    @MockBean
    private ConferenceService conferenceService;

    @MockBean
    private RegularSeason regularSeason;

    @Before
    public void setUp() throws Exception {
        SetupTestService setupTestService = new SetupTestService();
        mockMvc = setupTestService.defaultSetup(this, mockMvc, scheduleController);
    }

    @Test
    public void showSchedule_ShouldRenderSchedulePage() throws Exception {
        Conference testConference = new Conference();
        testConference.setConferenceTeams(Collections.emptyList());

        List<Conference> allConferences = List.of(testConference);

        given(conferenceService.findAllConferences()).willReturn(allConferences);

        mockMvc.perform(get("/schedule"))
                .andExpect(status().isOk())
                .andExpect(view().name("schedule"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/schedule.jsp"))
                .andExpect(model().attributeExists("conferences"))
                .andExpect(model().attribute("conferences", is(allConferences)));
    }

    @Test
    public void playRegularSeason_ShouldReturnConferenceList() throws Exception {
        Conference testConference1 = new Conference();
        testConference1.setConferenceTeams(Collections.emptyList());

        List<Conference> allConferences = List.of(testConference1);

        given(conferenceService.findAllConferences()).willReturn(allConferences);

        mockMvc.perform(post("/schedule"))
                .andExpect(status().isOk())
                .andExpect(view().name("schedule"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/schedule.jsp"))
                .andExpect(model().attributeExists("conf"))
                .andExpect(model().attribute("conf", is(allConferences)));
    }
}