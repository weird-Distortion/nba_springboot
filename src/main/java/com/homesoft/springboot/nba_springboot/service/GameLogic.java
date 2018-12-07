package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameLogic {

    private int scoreTeamA;
    private int scoreTeamB;

    public GameLogic() {
        this.scoreTeamA = 0;
        this.scoreTeamB = 0;
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

    public int countPoints(double attackRate, double defenceRate, Team team) {
        int result = 0;
        if (attackRate > defenceRate) {
            Random random = new Random();
            result += 2;
            double threePointChance = (random.nextInt(5) + 1) + team.getTeamThreePointRate();
            if (threePointChance >= 5.2) result++;
        }

        return result;
    }

    public void overtime() {
        Random random = new Random();
        int a = random.nextInt(6);
        int b = random.nextInt(6);

        if (a > b) {
            this.scoreTeamA += a;
        } else if (a < b) {
            this.scoreTeamB += b;
        } else overtime();
    }

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }
}
