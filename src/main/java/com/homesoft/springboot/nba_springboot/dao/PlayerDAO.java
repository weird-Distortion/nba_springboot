package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player, Integer> {
    List<Player> findByPlayerFirstName(String firstName);

    List<Player> findByPlayerLastName(String lastName);

    List<Player> findByPlayerNumber(int playerNumber);
}
