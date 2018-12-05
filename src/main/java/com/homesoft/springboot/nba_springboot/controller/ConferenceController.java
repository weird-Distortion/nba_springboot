package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/new-conference", method = RequestMethod.GET)
    public String addNewConference(ModelMap model) {
        model.addAttribute("conference", new Conference());
        return "new-conference";
    }

    @RequestMapping(value = "/new-conference", method = RequestMethod.POST)
    public String addConference(ModelMap model, Conference newConference) {
        conferenceService.persistConference(newConference);
        return "redirect:/schedule";
    }

    @RequestMapping(value = "/conference", method = RequestMethod.GET)
    public String showConferenceInfo(ModelMap model, @RequestParam int id) {
        Conference conference = conferenceService.getConferenceById(id);
        model.addAttribute("conferenceAttribute", conference);
        model.put("conference", conference);
        model.put("teams", conference.getConferenceTeams());
        model.put("divisions", conference.getConferenceDivisions());

        return "conference";
    }
}
