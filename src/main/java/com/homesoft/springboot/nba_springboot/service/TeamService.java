package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private static List<Team> teams = new ArrayList<>();
    private static int teamId = 4;

    static {
        teams.add(new Team("Rockets", "Houston"));
        teams.add(new Team("Heat", "Miami"));
        teams.add(new Team("Lakers", "Los Angeles"));
        teams.add(new Team("Raptors", "Toronto"));
    }

    public List<Team> retrieveTeams() {
        return teams;
    }

    public void addTeam(String title, String city) {
        teams.add(new Team(title, city));
    }

    public void removeTeam(int id) {
        teams.removeIf(team -> team.getTeamId() == id);
    }
}
