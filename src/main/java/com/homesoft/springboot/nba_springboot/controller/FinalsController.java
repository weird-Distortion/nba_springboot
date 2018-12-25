package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.PlayoffGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class FinalsController {

    @Autowired
    private PlayoffGameService playoffGameService;

    //TODO: fix bug with appearing previous champion
    private Team ch = new Team();

    @RequestMapping(value = "/finals", method = RequestMethod.GET)
    public String showFinalsPage(
            @SessionAttribute("champs") List<Team> champList,
            ModelMap model) {

        if (champList.size() < 1) {
            ch = null;
        } else {
            model.addAttribute("westChampion", champList.get(0));
            model.addAttribute("eastChampion", champList.get(1));
            model.addAttribute("champion", ch);
        }

        return "finals";
    }

    @RequestMapping(value = "/finals", method = RequestMethod.POST)
    public String playFinals(
            @SessionAttribute("champs") List<Team> champList,
            ModelMap model) {

        if (champList.size() > 0) {
            model.addAttribute("westChampion", champList.get(0));
            model.addAttribute("eastChampion", champList.get(1));
            ch = playoffGameService.playMatch(champList.get(0), champList.get(1));
            model.addAttribute("champion", ch);
        }

        return "finals";
    }
}
