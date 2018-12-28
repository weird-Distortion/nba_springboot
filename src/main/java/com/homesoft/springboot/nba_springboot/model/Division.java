package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Division {

    public Division() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;

    private String divisionTitle;

    @ManyToOne
    @JoinColumn(name = "conferenceId", nullable = false)
    private Conference divisionConference;

    @OneToMany(mappedBy = "teamDivision")
    private List<Team> divisionTeams;

    public int getDivisionId() {
        return divisionId;
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

    public List<Team> getSortedDivisionTeams() {
        return divisionTeams.stream()
                .sorted(Comparator.comparingInt(Team::getTeamWin)
                        .reversed())
                .collect(Collectors.toList());
    }
}
