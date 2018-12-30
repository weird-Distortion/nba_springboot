package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"nbaChampion", "champs", "playoffRounds", "westSchedule", "eastSchedule"})
public class WelcomeController implements NbaController {

    @ModelAttribute("nbaChampion")
    private Team setChampionTeam() {
        Team champion = new Team();
        champion.setTeamTitle("");
        return champion;
    }

    @ModelAttribute("champs")
    public List<Team> setUpChampList() {
        return new ArrayList<>();
    }

    @ModelAttribute("playoffRounds")
    public List<List<Team>> setRounds() {
        return new ArrayList<>();
    }

    @ModelAttribute("westSchedule")
    public List<List<Team>> setWestSchedule() {
        return new ArrayList<>();
    }

    @ModelAttribute("eastSchedule")
    public List<List<Team>> setEastSchedule() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(
            @ModelAttribute("nbaChampion") Team nbaChampion,
            @ModelAttribute("playoffRounds") List<List<Team>> rounds,
            @ModelAttribute("champs") List<Team> champList,
            @ModelAttribute("westSchedule") List<List<Team>> westSchedule,
            @ModelAttribute("eastSchedule") List<List<Team>> eastSchedule) {

        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showRegularSeason(
            @ModelAttribute("nbaChampion") Team nbaChampion,
            @ModelAttribute("playoffRounds") List<List<Team>> rounds,
            @ModelAttribute("champs") List<Team> champList,
            @ModelAttribute("westSchedule") List<List<Team>> westSchedule,
            @ModelAttribute("eastSchedule") List<List<Team>> eastSchedule) {

        return "redirect:/schedule";
    }

}