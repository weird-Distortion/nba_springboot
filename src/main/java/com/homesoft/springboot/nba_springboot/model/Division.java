package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * TODO: change this method to simple getter but implement sorting by Ajax
     *
     * @return
     */
    public List<Team> getSortedDivisionTeams() {
        return divisionTeams.stream()
                .sorted(Comparator.comparingInt(Team::getTeamWin)
                        .reversed())
                .collect(Collectors.toList());
    }

    public void setDivisionTeams(List<Team> divisionTeams) {
        this.divisionTeams = divisionTeams;
    }
}
