package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.PlayoffGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class FinalsController {

    @Autowired
    private PlayoffGameService playoffGameService;

    private Team ch = new Team();

    private void setChamp(Team team) {
        this.ch = team;
    }

    @RequestMapping(value = "/finals", method = RequestMethod.GET)
    public String showFinalsPage(
            @SessionAttribute("champs") List<Team> champList,
            ModelMap model) {

        model.addAttribute("champions", champList);
        model.addAttribute("champion", ch);

        return "finals";
    }

    @RequestMapping(value = "/finals", method = RequestMethod.POST)
    public String playFinals(
            @SessionAttribute("champs") List<Team> champList,
            ModelMap model) {
        model.addAttribute("champions", champList);
        ch = playoffGameService.playMatch(champList.get(0), champList.get(1));
        model.addAttribute("champion", ch);

        return "finals";
    }
}
