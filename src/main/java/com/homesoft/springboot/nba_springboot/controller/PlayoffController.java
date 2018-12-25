package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.PlayoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
@SessionAttributes(value =
        {"champs", "playoffRounds"})
public class PlayoffController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private PlayoffService playoffService;

    @ModelAttribute("champs")
    public List<Team> setUpChampList() {
        return new ArrayList<>();
    }

    @ModelAttribute("playoffRounds")
    public List<List<Team>> setRounds() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/playoff", method = RequestMethod.GET)
    public String showPlayoffPage(
            @ModelAttribute("champs") List<Team> champList,
            @SessionAttribute("westSchedule") List<List<Team>> westSchedule,
            @SessionAttribute("eastSchedule") List<List<Team>> eastSchedule,
            @ModelAttribute("playoffRounds") List<List<Team>> rounds,
            ModelMap model) {

        if (westSchedule.size() > 0 && eastSchedule.size() > 0) {
            model.addAttribute("rounds", rounds);
            model.addAttribute("westPairs", westSchedule);
            model.addAttribute("eastPairs", eastSchedule);
        }

        return "playoff";
    }

    @RequestMapping(value = "/playoff", method = RequestMethod.POST)
    public String playPlayoff(
            @ModelAttribute("champs") List<Team> champList,
            @SessionAttribute("westSchedule") List<List<Team>> westSchedule,
            @SessionAttribute("eastSchedule") List<List<Team>> eastSchedule,
            @ModelAttribute("playoffRounds") List<List<Team>> rounds,
            ModelMap model) {

        model.addAttribute("westPairs", westSchedule);
        model.addAttribute("eastPairs", eastSchedule);

        List<Team> westFirstRound = playoffService.playPlayoffFirstRound(westSchedule);
        List<Team> eastFirstRound = playoffService.playPlayoffFirstRound(eastSchedule);

        List<Team> westSecondRound = playoffService.playPlayoffGames(westFirstRound);
        List<Team> eastSecondRound = playoffService.playPlayoffGames(eastFirstRound);

        List<Team> westThirdRound = playoffService.playPlayoffGames(westSecondRound);
        List<Team> eastThirdRound = playoffService.playPlayoffGames(eastSecondRound);

        model.addAttribute("rounds", rounds);
        rounds.addAll(asList(westFirstRound, westSecondRound, westThirdRound, eastThirdRound, eastSecondRound, eastFirstRound));
        champList.addAll(asList(westThirdRound.get(0), eastThirdRound.get(0)));

        return "playoff";
    }
}
