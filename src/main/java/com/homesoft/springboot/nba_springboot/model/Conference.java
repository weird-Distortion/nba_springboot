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

    public Conference() {
        super();
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

//    public List<Team> retrieveAllConferenceTeams() {
//        return conferenceTeams;
//    }

    public void addTeamToConference(Team team) {
        assert team != null;
        conferenceTeams.add(team);
    }

//    public List<Division> retrieveAllConferenceDivisions() {
//        return conferenceDivisions;
//    }
//
//    public void addDivisionToConference(Division division) {
//        assert division != null && conferenceDivisions.size() < 3;
//        conferenceDivisions.add(division);
//    }

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
}
