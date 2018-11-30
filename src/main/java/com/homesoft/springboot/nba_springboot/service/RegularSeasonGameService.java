package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegularSeasonGameService implements GameService {

    @Autowired
    private TeamUpdateService teamUpdateService;

    private int scoreTeamA;
    private int scoreTeamB;

    public RegularSeasonGameService() {
        super();
        this.scoreTeamA = 0;
        this.scoreTeamB = 0;
    }

    @Override
    public void playMatch(Team teamA, Team teamB) {

        doShots(teamA, teamB);
        if (scoreTeamA == scoreTeamB) {
//            System.out.println("Overtime!");
            overtime();
        }

        teamA.setGamesPlayed(teamA.getGamesPlayed() + 1);
        teamB.setGamesPlayed(teamB.getGamesPlayed() + 1);

        if (scoreTeamA > scoreTeamB) {
            teamA.setTeamWin(teamA.getTeamWin() + 1);
            teamB.setTeamLose(teamB.getTeamLose() + 1);
        } else {
            teamB.setTeamWin(teamB.getTeamWin() + 1);
            teamA.setTeamLose(teamA.getTeamLose() + 1);
        }

        teamUpdateService.updateTeam(teamA, teamA.getGamesPlayed(), teamA.getTeamWin(), teamA.getTeamLose(), teamA.getTeamId());
        teamUpdateService.updateTeam(teamB, teamB.getGamesPlayed(), teamB.getTeamWin(), teamB.getTeamLose(), teamB.getTeamId());

        scoreTeamA = 0;
        scoreTeamB = 0;
    }

    public void doShots(Team teamA, Team teamB) {
        Random random = new Random();
        int shotsPerGame = random.nextInt(10) + 110;
        int counter = 0;

        while (counter < shotsPerGame) {
            double attackTeamA = (random.nextInt(6) + 1) + teamA.getTeamAttackRate();
            double defenceTeamA = (random.nextInt(6) + 1) + teamA.getTeamDefenceRate();
            double attackTeamB = (random.nextInt(6) + 1) + teamB.getTeamAttackRate();
            double defenceTeamB = (random.nextInt(6) + 1) + teamB.getTeamDefenceRate();

            scoreTeamA += countPoints(attackTeamA, defenceTeamB, teamA);
            scoreTeamB += countPoints(attackTeamB, defenceTeamA, teamB);

            counter++;
        }
    }

    private int countPoints(double attack, double defence, Team team) {
        int result = 0;
        if (attack > defence) {
            Random random = new Random();
            result += 2;
            double threePointChance = (random.nextInt(5) + 1) + team.getTeamThreePointRate();
            if (threePointChance >= 5.2) result++;
        }

        return result;
    }

    private void overtime() {
        Random random = new Random();
        int a = random.nextInt(6);
        int b = random.nextInt(6);

        if (a > b) {
            scoreTeamA += a;
        } else if (a < b) {
            scoreTeamB += b;
        } else overtime();
    }
}
