package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.AutoDataService;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class PlayAgainController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private AutoDataService autoDataService;

    @RequestMapping(value = "/play-again", method = RequestMethod.GET)
    public String showPlayAgainPage(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());

        return "play-again";
    }

    //TODO: create all session attributes on the first page (?)
    @RequestMapping(value = "/play-again", method = RequestMethod.POST)
    public String playAgain(
            @SessionAttribute("champs") List<Team> champList,
            @SessionAttribute("westSchedule") List<List<Team>> westSchedule,
            @SessionAttribute("eastSchedule") List<List<Team>> eastSchedule,
            @SessionAttribute("playoffRounds") List<List<Team>> rounds,
            @SessionAttribute("nbaChampion") Team nbaChampion,
            ModelMap model) {
        autoDataService.resetSeasonResults();
        champList.clear();
        westSchedule.clear();
        eastSchedule.clear();
        rounds.clear();
        nbaChampion.setTeamTitle("");

        return "redirect:/schedule";
    }
}
