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
        teams.add(new Team(1, "Rockets", "Housto"));
        teams.add(new Team(2, "Heat", "Miami"));
        teams.add(new Team(3, "Lakers", "Los Angeles"));
        teams.add(new Team(4, "Raptors", "Toronto"));
    }

    public List<Team> retrieveTeams() {
        return teams;
    }

    public void addTeam(String title, String city) {
        teams.add(new Team(++teamId, title, city));
    }

    public void removeTeam(int id) {
        teams.removeIf(team -> team.getId() == id);
    }
}
