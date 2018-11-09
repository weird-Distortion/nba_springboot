package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamsController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private ConferenceDAO conferenceDAO;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {

        model.put("conferences", conferenceDAO.findAll());
        model.put("teams", teamDAO.findAll());
        return "schedule";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public String addNewTeam(ModelMap model) {
        model.addAttribute("conference", conferenceDAO.findAll());
        model.addAttribute("team", new Team());
        return "new-team";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.POST)
    public String addTeam(ModelMap model, Team newTeam, @ModelAttribute Conference conference) {
        teamDAO.save(newTeam);
        return "redirect:/schedule";
    }
}
