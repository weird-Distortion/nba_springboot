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

    @ManyToOne
    @JoinColumn(name = "conferenceId", nullable = false)
    private Conference teamConference;

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
}
