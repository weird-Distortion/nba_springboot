package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column
    private String teamTitle;

    @Column
    private String teamCity;

    @Column(columnDefinition="Decimal(10,0) default '0'")
    private int gamesPlayed;

    @Column(columnDefinition="Decimal(10,0) default '0'")
    private int teamWin;

    @Column(columnDefinition="Decimal(10,0) default '0'")
    private int teamLose;

    @Column(columnDefinition="Decimal(10,2) default '0.00'")
    private double teamWinrate;

    @ManyToOne
    @JoinColumn(name = "conferenceId", nullable = false)
    private Conference teamConference;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    private Division teamDivision;

    @OneToMany(mappedBy = "playerTeam")
    private List<Player> teamPlayers;

    public Team() { super(); }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

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

    public double getTeamWinrate() {
        return teamWinrate;
    }

    public void setTeamWinrate(double teamWinrate) {
        this.teamWinrate = teamWinrate;
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

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public Division getTeamDivision() {
        return teamDivision;
    }

    public void setTeamDivision(Division teamDivision) {
        this.teamDivision = teamDivision;
    }
}
