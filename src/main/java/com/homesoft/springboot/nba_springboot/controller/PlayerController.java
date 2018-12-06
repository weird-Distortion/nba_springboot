package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Player;
import com.homesoft.springboot.nba_springboot.service.PlayerService;
import com.homesoft.springboot.nba_springboot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController implements NbaController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/new-player", method = RequestMethod.GET)
    public String showAddNewPlayerPage(ModelMap model) {

        model.addAttribute("newPlayer", playerService.createPlayer());
        model.addAttribute("team", teamService.findAllTeams());
        return "new-player";
    }

    @RequestMapping(value = "/new-player", method = RequestMethod.POST)
    public String addNewPlayer(ModelMap model, Player newPlayer) {
        playerService.persistPlayer(newPlayer);
        return "redirect:/schedule";
    }

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public String showPlayerInfo(ModelMap model, @RequestParam int id) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("playerAttribute", player);
        model.put("teams", teamService.findAllTeams());
        return "player";
    }

    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public String mergePlayer(Player player, @RequestParam int id) {
        playerService.removePlayerById(id);
        playerService.persistPlayer(player);
        return "redirect:/schedule";
    }
}
