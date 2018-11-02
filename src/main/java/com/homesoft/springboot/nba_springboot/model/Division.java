package com.homesoft.springboot.nba_springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private List<Team> teams;

    public Division() {
        this.teams = new ArrayList<>();
    }

    public Division(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeamToDivision(Team team) {
        assert team != null;
        this.teams.add(team);
    }

    public void removeTeamFromDivision(Team team) {
        assert team != null && teams.size() > 0;
        this.teams.remove(team);
    }

    public List<Team> retrieveAllTeams() {
        return teams;
    }
}
