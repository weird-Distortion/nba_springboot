package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player, Integer> {
    Player findByPlayerFirstName(String firstName);

    Player findByPlayerLastName(String lastName);

    Player findByPlayerNumber(int playerNumber);
}
