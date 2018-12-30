package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.PlayoffGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FinalsController {

    @Autowired
    private PlayoffGameService playoffGameService;

    @RequestMapping(value = "/finals", method = RequestMethod.GET)
    public String showFinalsPage(
            @SessionAttribute("champs") List<Team> champList,
            @SessionAttribute("nbaChampion") Team nbaChampion,
            ModelMap model) {

        if (champList.size() > 0) {
            model.addAttribute("westChampion", champList.get(0));
            model.addAttribute("eastChampion", champList.get(1));
            model.addAttribute("champion", nbaChampion);
        }

        return "finals";
    }

    @RequestMapping(value = "/finals", method = RequestMethod.POST)
    public String playFinals(
            @SessionAttribute("champs") List<Team> champList,
            @SessionAttribute("nbaChampion") Team nbaChampion,
            ModelMap model) {

        if (!nbaChampion.getTeamTitle().equals("") || champList.size() == 0) {
            return "redirect:/finals";
        }

        model.addAttribute("westChampion", champList.get(0));
        model.addAttribute("eastChampion", champList.get(1));
        Team ch = playoffGameService.playMatch(champList.get(0), champList.get(1));
        nbaChampion.setTeamTitle(ch.getTeamTitle());

        model.addAttribute("champion", nbaChampion);


        return "finals";
    }
}
