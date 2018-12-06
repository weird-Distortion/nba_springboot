package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Player;
import com.homesoft.springboot.nba_springboot.service.PlayerService;
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
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PlayerController playerController;

    @MockBean
    private TeamService teamService;

    @MockBean
    private PlayerService playerService;

    @Before
    public void setUp() {
        SetupTestService setupTestService = new SetupTestService();
        mockMvc = setupTestService.defaultSetup(this, mockMvc, playerController);
    }

    @Test
    public void showAddNewPlayerPage_ShouldRenderNewPlayerPage() throws Exception {
        Player testPlayer = new Player();

        given(playerService.createPlayer()).willReturn(testPlayer);

        mockMvc.perform(get("/new-player"))
                .andExpect(status().isOk())
                .andExpect(view().name("new-player"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/new-player.jsp"))
                .andExpect(model().attributeExists("newPlayer"))
                .andExpect(model().attribute("newPlayer", is(testPlayer)));
    }

    @Test
    public void addNewPlayer_ShouldCreateNewPlayerAndRedirectToSchedule() throws Exception {
        mockMvc.perform(post("/new-player")
                .param("playerFirstName", "testPlayerFirstName"))
                .andExpect(view().name("redirect:" + "/schedule"))
                .andExpect(model().hasNoErrors())
                .andExpect(status().isFound());
    }

    @Test
    public void showPlayerInfo_ShouldRenderPlayerPage() throws Exception {
        Player testPlayer = new Player();
        int testPlayerId = 9;

        given(playerService.getPlayerById(testPlayerId)).willReturn(testPlayer);

        mockMvc.perform(get("/player?id=" + testPlayerId))
                .andExpect(status().isOk())
                .andExpect(view().name("player"))
                .andExpect(model().attributeExists("playerAttribute"))
                .andExpect(model().attribute("playerAttribute", is(testPlayer)));
    }
}