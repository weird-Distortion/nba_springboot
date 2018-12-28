package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    public Team() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column
    private String teamTitle;

    @Column
    private String teamCity;

    @Column(columnDefinition = "Decimal(10,0) default '0'")
    private int gamesPlayed;

    @Column(columnDefinition = "Decimal(10,0) default '0'")
    private int teamWin;

    @Column(columnDefinition = "Decimal(10,0) default '0'")
    private int teamLose;

    @ManyToOne
    @JoinColumn(name = "conferenceId", nullable = false)
    private Conference teamConference;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division teamDivision;

    @OneToMany(mappedBy = "playerTeam")
    private List<Player> teamPlayers;

    public int getTeamId() {
        return teamId;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getTeamWin() {
        return teamWin;
    }

    public void setTeamWin(int teamWin) {
        this.teamWin = teamWin;
    }

    public int getTeamLose() {
        return teamLose;
    }

    public void setTeamLose(int teamLose) {
        this.teamLose = teamLose;
    }

    /**
     * Methods calculate and return team attack, defence, three point and win rates.
     * @return
     */

    public double getTeamWinrate() {
        if (this.gamesPlayed == 0) return 0.0;

        return Math.round(
                ((Double.parseDouble(String.valueOf(this.teamWin)) /
                        Double.parseDouble(String.valueOf(this.gamesPlayed)))) * 100 * 100d
        ) / 100d;
    }

    public double getTeamAttackRate() {
        if (teamPlayers.size() == 0) return 0.0;

        return Math.round(
                teamPlayers.stream().mapToDouble(Player::getPlayerAttackRate).sum() / teamPlayers.size() * 100d
        ) / 100d;
    }

    public double getTeamDefenceRate() {
        if (teamPlayers.size() == 0) return 0.0;

        return Math.round(
                teamPlayers.stream().mapToDouble(Player::getPlayerDefenceRate).sum() / teamPlayers.size()* 100d
        ) / 100d;
    }

    public double getTeamThreePointRate() {
        if (teamPlayers.size() == 0) return 0.0;

        return Math.round(
                teamPlayers.stream().mapToDouble(Player::getPlayerThreePointRate).sum() / teamPlayers.size()* 100d
        ) / 100d;
    }

    public Conference getTeamConference() {
        return teamConference;
    }

    public void setTeamConference(Conference teamConference) {
        this.teamConference = teamConference;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public Division getTeamDivision() {
        return teamDivision;
    }

    public void setTeamDivision(Division teamDivision) {
        this.teamDivision = teamDivision;
    }
}
