package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.PlayoffService;
import com.homesoft.springboot.nba_springboot.service.RegularSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"westSchedule", "eastSchedule"})
public class ScheduleController implements NbaController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private RegularSeason regularSeason;

    @Autowired
    private PlayoffService playoffService;

    @ModelAttribute("westSchedule")
    public List<List<Team>> setWestSchedule() {
        return new ArrayList<>();
    }

    @ModelAttribute("eastSchedule")
    public List<List<Team>> setEastSchedule() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());
        return "schedule";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String playRegularSeason(
            @ModelAttribute("westSchedule") List<List<Team>> westSchedule,
            @ModelAttribute("eastSchedule") List<List<Team>> eastSchedule,
            ModelMap model) {
        if (conferenceService.findAllConferences().size() == 2) {
            regularSeason
                    .playRegularSeasonGames(conferenceService.getConferenceById(1),
                            conferenceService.getConferenceById(2));

            model.addAttribute("conferences", conferenceService.findAllConferences());

            westSchedule.addAll(playoffService
                    .makeConferenceSchedule(conferenceService
                            .getConferenceById(1)
                            .getConferencePlayoffTeams()));

            eastSchedule.addAll(playoffService
                    .makeConferenceSchedule(conferenceService
                            .getConferenceById(2)
                            .getConferencePlayoffTeams()));
        }

        return "schedule";
    }
}
