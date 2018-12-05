package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeamDAO extends JpaRepository<Team, Integer> {
    Team findByTeamTitle(String teamTitle);

    List<Team> findByTeamCity(String teamCity);

    List<Team> findByGamesPlayed(int gamesPlayed);

    List<Team> findByTeamWin(int teamWin);

    List<Team> findByTeamLose(int teamLose);
}
