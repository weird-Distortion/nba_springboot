package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamsController {

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {

        model.put("teams", teamService.retrieveTeams());
        return "schedule";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String addTeam(ModelMap model, @RequestParam String teamTitle, @RequestParam String teamCity) {
        teamService.addTeam(teamTitle, teamCity);

        model.put("teams", teamService.retrieveTeams());
        return "schedule";
    }
}
