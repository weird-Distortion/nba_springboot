package com.homesoft.springboot.nba_springboot.model;

import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
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
public class TeamTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TeamDAO teamDAO;

    private Team testTeam;

    @Before
    public void setUp() throws Exception {
        Conference testConference = new Conference();
        Division testDivision = new Division();
        testDivision.setDivisionConference(testConference);

        testTeam = new Team();
        testTeam.setTeamTitle("testTeamTitle");
        testTeam.setTeamCity("testTeamCity");
        testTeam.setGamesPlayed(10);
        testTeam.setTeamWin(4);
        testTeam.setTeamLose(6);
        testTeam.setTeamConference(testConference);
        testTeam.setTeamDivision(testDivision);

        testEntityManager.persistAndFlush(testConference);
        testEntityManager.persistAndFlush(testDivision);
        testEntityManager.persistAndFlush(testTeam);
    }

    @Test
    public void whenFindByTeamTitle_returnTeam() {
        Team foundTeam = teamDAO.findByTeamTitle(testTeam.getTeamTitle());

        assertThat(foundTeam.getTeamTitle()).isEqualTo(testTeam.getTeamTitle());
    }

    @Test
    public void whenFindByTeamCity_returnTeamList() {
        List<Team> foundTeamList = teamDAO.findByTeamCity(testTeam.getTeamCity());

        foundTeamList.forEach(team ->
                assertThat(team.getTeamCity()).isEqualTo(testTeam.getTeamCity()));
    }

    @Test
    public void whenFindByGamesPlayed_returnTeamList() {
        List<Team> foundTeamList = teamDAO.findByGamesPlayed(testTeam.getGamesPlayed());

        foundTeamList.forEach(team ->
                assertThat(team.getGamesPlayed()).isEqualTo(testTeam.getGamesPlayed()));
    }

    @Test
    public void whenFindByTeamWin_returnTeamList() {
        List<Team> foundTeamList = teamDAO.findByTeamWin(testTeam.getTeamWin());

        foundTeamList.forEach(team ->
                assertThat(team.getTeamWin()).isEqualTo(testTeam.getTeamWin()));
    }

    @Test
    public void whenFindByTeamLose_returnTeamList() {
        List<Team> foundTeamList = teamDAO.findByTeamLose(testTeam.getTeamLose());

        foundTeamList.forEach(team ->
                assertThat(team.getTeamLose()).isEqualTo(testTeam.getTeamLose()));
    }
}