package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.RegularSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScheduleController implements NbaController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private RegularSeason regularSeason;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {
//        model.put("conferences", conferenceService.findAllConferences());
        model.addAttribute("conferences", conferenceService.findAllConferences());
        return "schedule";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String playRegularSeason(ModelMap model) {
        regularSeason.playRegularSeasonGames(conferenceService.getConferenceById(1), conferenceService.getConferenceById(2));
        model.addAttribute("conf", conferenceService.findAllConferences());
        model.put("conferences", conferenceService.findAllConferences());
        return "schedule";
    }
}
