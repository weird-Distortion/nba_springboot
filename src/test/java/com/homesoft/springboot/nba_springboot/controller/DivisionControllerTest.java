package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Division;
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
@WebMvcTest(DivisionController.class)
public class DivisionControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private DivisionController divisionController;

    @MockBean
    private ConferenceService conferenceService;

    @MockBean
    private DivisionService divisionService;

    @MockBean
    private TeamService teamService;

    @Before
    public void setUp() throws Exception {
        SetupTestService setupTestService = new SetupTestService();
        mockMvc = setupTestService.defaultSetup(this, mockMvc, divisionController);
    }

    @Test
    public void showNewDivisionPage_ShouldCreateNewDivisionAndRenderNewDivisionPage() throws Exception {
        Division testDivision = new Division();

        given(divisionService.createNewDivision()).willReturn(testDivision);

        mockMvc.perform(get("/new-division"))
                .andExpect(status().isOk())
                .andExpect(view().name("new-division"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/new-division.jsp"))
                .andExpect(model().attributeExists("division"))
                .andExpect(model().attribute("division", is(testDivision)));
    }

    @Test
    public void addDivision_ShouldAddNewDivisionAndRedirectToSchedule() throws Exception {
        Division testDivision = new Division();

        mockMvc.perform(post("/new-division")
                .param("divisionTitle", "testDivisionTitle"))
                .andExpect(view().name("redirect:" + "/schedule"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isFound());
    }
}