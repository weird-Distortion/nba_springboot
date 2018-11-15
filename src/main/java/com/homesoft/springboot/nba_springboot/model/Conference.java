package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conferenceId;

    private String conferenceTitle;

    @OneToMany(mappedBy = "teamConference")
    private List<Team> conferenceTeams;

    @OneToMany(mappedBy = "divisionConference")
    private List<Division> conferenceDivisions;

    public Conference() {
        super();
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public void addTeamToConference(Team team) {
        assert team != null;
        conferenceTeams.add(team);
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public List<Team> getConferenceTeams() {
        return conferenceTeams;
    }

    public void setConferenceTeams(List<Team> conferenceTeams) {
        this.conferenceTeams = conferenceTeams;
    }

    public List<Division> getConferenceDivisions() {
        return conferenceDivisions;
    }

    public void setConferenceDivisions(List<Division> conferenceDivisions) {
        this.conferenceDivisions = conferenceDivisions;
    }
}
