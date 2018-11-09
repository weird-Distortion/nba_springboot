package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.PlayerDAO;
import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @RequestMapping(value = "/new-player", method = RequestMethod.GET)
    public String addNewPlayer(ModelMap model) {

        model.addAttribute("player", new Player());
        model.addAttribute("team", teamDAO.findAll());
        return "new-player";
    }

    @RequestMapping(value = "/new-player", method = RequestMethod.POST)
    public String addPlayer(ModelMap model, Player newPlayer) {
        playerDAO.save(newPlayer);
        return "redirect:/schedule";
    }
}
