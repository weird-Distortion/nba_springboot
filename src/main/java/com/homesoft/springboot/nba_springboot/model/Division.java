package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int divisionId;

    @Column
    private String divisionTitle;

    @ManyToOne
    @JoinColumn(name = "conferenceId", nullable = false)
    private Conference divisionConference;

    @OneToMany(mappedBy = "teamDivision")
    private List<Team> divisionTeams;

    public Division() {
        super();
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionTitle() {
        return divisionTitle;
    }

    public void setDivisionTitle(String divisionTitle) {
        this.divisionTitle = divisionTitle;
    }

    public Conference getDivisionConference() {
        return divisionConference;
    }

    public void setDivisionConference(Conference divisionConference) {
        this.divisionConference = divisionConference;
    }

    public List<Team> getDivisionTeams() {
        return divisionTeams;
    }

    public void setDivisionTeams(List<Team> divisionTeams) {
        this.divisionTeams = divisionTeams;
    }
}
