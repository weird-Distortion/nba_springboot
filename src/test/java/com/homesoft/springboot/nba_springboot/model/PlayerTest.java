package com.homesoft.springboot.nba_springboot.model;

import com.homesoft.springboot.nba_springboot.dao.PlayerDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PlayerDAO playerDAO;

    private Player testPlayer;

    @Before
    public void setUp() throws Exception {
        Conference testConference = new Conference();
        Division testDivision = new Division();
        testDivision.setDivisionConference(testConference);
        Team testTeam = new Team();
        testTeam.setTeamConference(testConference);
        testTeam.setTeamDivision(testDivision);
        testPlayer = new Player();
        testPlayer.setPlayerFirstName("testPlayerFirstName");
        testPlayer.setPlayerLastName("testPlayerLastName");
        testPlayer.setPlayerNumber(5);
        testPlayer.setPlayerTeam(testTeam);

        testEntityManager.persistAndFlush(testConference);
        testEntityManager.persistAndFlush(testDivision);
        testEntityManager.persistAndFlush(testTeam);
        testEntityManager.persistAndFlush(testPlayer);
    }

    @Test
    public void whenFindByPlayerFirstName_returnPlayerList() {
        List<Player> foundPlayerList = playerDAO.findByPlayerFirstName(testPlayer.getPlayerFirstName());

        foundPlayerList.forEach(player ->
                assertThat(player.getPlayerFirstName()).isEqualTo(testPlayer.getPlayerFirstName()));
    }

    @Test
    public void whenFindByPlayerLastName_returnPlayerList() {
        List<Player> foundPlayerList = playerDAO.findByPlayerLastName(testPlayer.getPlayerLastName());

        foundPlayerList.forEach(player ->
                assertThat(player.getPlayerLastName()).isEqualTo(testPlayer.getPlayerLastName()));
    }

    @Test
    public void whenFindByPlayerName_returnPlayerList() {
        List<Player> foundPlayerList = playerDAO.findByPlayerNumber(testPlayer.getPlayerNumber());

        foundPlayerList.forEach(player ->
                assertThat(player.getPlayerNumber()).isEqualTo(testPlayer.getPlayerNumber()));
    }
}