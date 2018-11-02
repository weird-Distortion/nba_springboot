package com.homesoft.springboot.nba_springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {
    private String conferenceTitle;
    private List<Team> conferenceTeams;
    private List<Division> conferenceDivisions;

    public Conference(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
        this.conferenceTeams = new ArrayList<>();
        this.conferenceDivisions = new ArrayList<>();
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public List<Team> retrieveAllConferenceTeams() {
        return conferenceTeams;
    }

    public void addTeamToConference(Team team) {
        assert team != null && conferenceTeams.size() < 15;
        conferenceTeams.add(team);
    }

    public List<Division> retrieveAllConferenceDivisions() {
        return conferenceDivisions;
    }

    public void addDivisionToConference(Division division) {
        assert division != null && conferenceDivisions.size() < 3;
        conferenceDivisions.add(division);
    }
}
