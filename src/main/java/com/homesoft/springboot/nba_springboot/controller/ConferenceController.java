package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConferenceController {

    @Autowired
    private ConferenceDAO conferenceDAO;

    @Autowired
    private TeamDAO teamDAO;

    @RequestMapping(value = "/new-conference", method = RequestMethod.GET)
    public String addNewConference(ModelMap model) {

        model.addAttribute("conference", new Conference());
        return "new-conference";
    }

    @RequestMapping(value = "/new-conference", method = RequestMethod.POST)
    public String addConference(ModelMap model, Conference newConference) {
        conferenceDAO.save(newConference);
        return "redirect:/schedule";
    }

    @RequestMapping(value = "/conference", method = RequestMethod.GET)
    public String showConferenceInfo(ModelMap model, @RequestParam int id) {
        Conference conference = conferenceDAO.findById(id).get();
        model.addAttribute("conferenceAttribute", conference);
        model.put("conference", conference);
        model.put("teams", conference.getConferenceTeams());
        model.put("divisions", conference.getConferenceDivisions());

        return "conference";
    }
}
