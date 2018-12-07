package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
public class GameLogicTest {

    private GameLogic gameLogic;
    private Team teamA;
    private Team teamB;

    @Before
    public void setUp() {
        teamA = mock(Team.class);
        teamB = mock(Team.class);
        gameLogic = new GameLogic();
    }

    @Test
    public void doShots() {
        gameLogic.doShots(teamA, teamB);

        assert(gameLogic.getScoreTeamA() > 0 && gameLogic.getScoreTeamB() > 0);
    }

    @Test
    public void countPoints() {
        int testTrueResult = gameLogic.countPoints(1.5, 1.2, teamA);
        int testFalseResult = gameLogic.countPoints(1.1, 2, teamA);

        assert(testTrueResult > 0 && testFalseResult == 0);
    }

    @Test
    public void overtime() {
        gameLogic.overtime();

        assert(gameLogic.getScoreTeamB() != 0 || gameLogic.getScoreTeamA() != 0);
    }
}