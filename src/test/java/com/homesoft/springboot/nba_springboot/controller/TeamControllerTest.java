package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.DivisionService;
import com.homesoft.springboot.nba_springboot.service.TeamService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private TeamController teamController;

    @MockBean
    private ConferenceService conferenceService;

    @MockBean
    private DivisionService divisionService;

    @MockBean
    private TeamService teamService;

    @Before
    public void setUp() throws Exception {
        SetupTestService setupTestService = new SetupTestService();
        mockMvc = setupTestService.defaultSetup(this, mockMvc, teamController);
    }

    @Test
    public void showNewTeamPage_ShouldRenderNewTeamPage() throws Exception {
        Team testTeam = new Team();

        given(teamService.createTeam()).willReturn(testTeam);

        mockMvc.perform(get("/new-team"))
                .andExpect(status().isOk())
                .andExpect(view().name("new-team"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/new-team.jsp"))
                .andExpect(model().attributeExists("team"))
                .andExpect(model().attribute("team", is(testTeam)));
    }

    @Test
    public void addTeam_ShouldAddNewTeamAndRedirectToSchedule() throws Exception {
        mockMvc.perform(post("/new-team")
                .param("teamTitle", "testTeamTitle"))
                .andExpect(view().name("redirect:" + "/schedule"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isFound());
    }

    @Test
    public void showTeamInfo_ShouldRenderTeamPage() throws Exception {
        Team testTeam = new Team();
        int testTeamId = 5;

        given(teamService.findTeamById(testTeamId)).willReturn(testTeam);

        mockMvc.perform(get("/team?id=" + testTeamId))
                .andExpect(view().name("team"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("team"))
                .andExpect(model().attribute("team", is(testTeam)));
    }
}