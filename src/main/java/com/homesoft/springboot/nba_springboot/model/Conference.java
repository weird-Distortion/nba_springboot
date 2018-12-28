package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Conference {

    public Conference() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conferenceId;

    private String conferenceTitle;

    @OneToMany(mappedBy = "teamConference")
    private List<Team> conferenceTeams;

    @OneToMany(mappedBy = "divisionConference")
    private List<Division> conferenceDivisions;

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public int getConferenceId() {
        return conferenceId;
    }

    public List<Team> getConferenceTeams() {
        return conferenceTeams.stream()
                .sorted(Comparator.comparingInt(Team::getTeamWin)
                        .reversed())
                .collect(Collectors.toList());
    }

    public List<Team> getConferencePlayoffTeams() {
        return conferenceTeams.stream()
                .sorted(Comparator.comparingInt(Team::getTeamWin)
                        .reversed())
                .limit(8)
                .collect(Collectors.toList());
    }

    public void setConferenceTeams(List<Team> conferenceTeams) {
        this.conferenceTeams = conferenceTeams;
    }

    public List<Division> getConferenceDivisions() {
        return conferenceDivisions;
    }
}
