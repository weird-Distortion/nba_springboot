package com.homesoft.springboot.nba_springboot.model;

public class Team {
    private int id;
    private String teamTitle;
    private String teamCity;

    public Team() { super(); }

    public Team(String teamTitle, String teamCity) {
        super();
        this.teamTitle = teamTitle;
        this.teamCity = teamCity;
    }

    public int getTeamId() {
        return id;
    }

    public String getTeamTitle() {
        return teamTitle;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamTitle(String teamTitle) {
        this.teamTitle = teamTitle;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }
}
