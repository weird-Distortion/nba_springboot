package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TeamDAO extends JpaRepository<Team, Integer> {
}
