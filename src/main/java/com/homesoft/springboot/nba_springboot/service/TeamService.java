package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamDAO teamDAO;

    public Team findTeamById(int teamId) {
        return teamDAO.getOne(teamId);
    }

    public void persistTeam(Team team) {
        teamDAO.save(team);
    }

    public List<Team> findAllTeams() {
        return teamDAO.findAll();
    }
}
