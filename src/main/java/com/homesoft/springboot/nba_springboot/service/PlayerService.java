package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.dao.PlayerDAO;
import com.homesoft.springboot.nba_springboot.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    public Player getPlayerById(int playerId) {
        return playerDAO.getOne(playerId);
    }

    public List<Player> findAllPlayers() {
        return playerDAO.findAll();
    }

    public void persistPlayer(Player player) {
        if (player
                .getPlayerTeam()
                .getTeamPlayers()
                .size() < 5)
            playerDAO.save(player);
    }

    public void removePlayerById(int id) {
        playerDAO.deleteById(id);
    }

    public Player createPlayer() {
        return new Player();
    }
}
