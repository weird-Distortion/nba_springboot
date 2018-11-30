package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public class TeamUpdateService {

    @Autowired
    private JdbcOperations jdbcOperations;

    public void updateTeam(Team team, int gamesPlayed, int win, int lose, int id) {
        jdbcOperations.update("update team set games_played = ?, team_win = ?, team_lose = ? where team_id = ?;", gamesPlayed, win, lose, id);
    }
}
