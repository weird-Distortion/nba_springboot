package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayoffGameService {

    @Autowired
    private GameLogic gameLogic;

    @Autowired
    private TeamUpdateService teamUpdateService;

    public Team playMatch(Team teamA, Team teamB) {
        int teamAWins = 0, teamBWins = 0;

        while (teamAWins <= 3 && teamBWins <= 3) {
            gameLogic.doShots(teamA, teamB);

            if (gameLogic.getScoreTeamA() == gameLogic.getScoreTeamB()) {
//                System.out.println("Overtime!");
                gameLogic.overtime();
            }

            if (gameLogic.getScoreTeamA() > gameLogic.getScoreTeamB()) {
                teamA.setTeamWin(teamA.getTeamWin() + 1);
                teamAWins++;
            } else {
                teamB.setTeamWin(teamB.getTeamWin() + 1);
                teamBWins++;
            }

//            teamUpdateService.updateTeam(teamA, teamA.getGamesPlayed(), teamA.getTeamWin(), teamA.getTeamLose(), teamA.getTeamId());
//            teamUpdateService.updateTeam(teamB, teamB.getGamesPlayed(), teamB.getTeamWin(), teamB.getTeamLose(), teamB.getTeamId());
            gameLogic.setScoreTeamA(0);
            gameLogic.setScoreTeamB(0);
        }
        return teamAWins > teamBWins ? teamA : teamB;
    }
}