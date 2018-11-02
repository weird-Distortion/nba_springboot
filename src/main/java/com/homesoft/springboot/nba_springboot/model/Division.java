package com.homesoft.springboot.nba_springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private String divisionTitle;
    private List<Team> divisionTeams;

    public Division(String divisionTitle) {
        this.divisionTitle = divisionTitle;
        this.divisionTeams = new ArrayList<>();
    }

    public void addTeamToDivision(Team team) {
        assert team != null && divisionTeams.size() < 5;
        this.divisionTeams.add(team);
    }

    public void removeTeamFromDivision(Team team) {
        assert team != null && divisionTeams.size() > 0;
        this.divisionTeams.remove(team);
    }

    public List<Team> retrieveAllDivisionTeams() {
        return divisionTeams;
    }

    public String getDivisionTitle() {
        return divisionTitle;
    }

    public void setDivisionTitle(String divisionTitle) {
        this.divisionTitle = divisionTitle;
    }

    @Override
    public String toString() {
        return "Division{" +
                "divisionTitle='" + divisionTitle + '\'' +
                ", divisionTeams=" + divisionTeams +
                '}';
    }
}
