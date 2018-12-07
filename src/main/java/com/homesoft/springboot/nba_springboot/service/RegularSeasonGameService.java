package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularSeasonGameService implements GameService {

    @Autowired
    private TeamUpdateService teamUpdateService;

    @Autowired
    private GameLogic gameLogic;

    @Override
    public void playMatch(Team teamA, Team teamB) {

        gameLogic.doShots(teamA, teamB);

        if (gameLogic.getScoreTeamA() == gameLogic.getScoreTeamB()) {
//            System.out.println("Overtime!");
            gameLogic.overtime();
        }

        teamA.setGamesPlayed(teamA.getGamesPlayed() + 1);
        teamB.setGamesPlayed(teamB.getGamesPlayed() + 1);

        if (gameLogic.getScoreTeamA() > gameLogic.getScoreTeamB()) {
            teamA.setTeamWin(teamA.getTeamWin() + 1);
            teamB.setTeamLose(teamB.getTeamLose() + 1);
        } else {
            teamB.setTeamWin(teamB.getTeamWin() + 1);
            teamA.setTeamLose(teamA.getTeamLose() + 1);
        }

        teamUpdateService.updateTeam(teamA, teamA.getGamesPlayed(), teamA.getTeamWin(), teamA.getTeamLose(), teamA.getTeamId());
        teamUpdateService.updateTeam(teamB, teamB.getGamesPlayed(), teamB.getTeamWin(), teamB.getTeamLose(), teamB.getTeamId());

        gameLogic.setScoreTeamA(0);
        gameLogic.setScoreTeamB(0);
    }
}
