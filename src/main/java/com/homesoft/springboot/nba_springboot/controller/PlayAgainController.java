package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.service.AutoDataService;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/play-again", method = RequestMethod.POST)
    public String playAgain(ModelMap model) {
        autoDataService.resetSeasonResults();
        return "redirect:/schedule";
    }
}
