package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayoffController {

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/playoff", method = RequestMethod.GET)
    public String showPlayoffPage(ModelMap model) {
        Conference west = conferenceService.getConferenceById(1);
        Conference east = conferenceService.getConferenceById(2);
        model.addAttribute("westTeams", west.getConferencePlayoffTeams());
        model.addAttribute("eastTeams", east.getConferencePlayoffTeams());

        return "playoff";
    }
}
