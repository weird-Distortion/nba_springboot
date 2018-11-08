package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
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

    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public String addNewTeam(ModelMap model) {

        model.addAttribute("team", new Team());
        return "new-team";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.POST)
    public String addTeam(ModelMap model, Team newTeam) {
//        teamService.addTeam(teamTitle, teamCity);
        teamService.addTeam(newTeam.getTeamTitle(), newTeam.getTeamCity());
        System.out.println(newTeam.getTeamTitle() + " :::::::::::::::: " + newTeam.getTeamCity());
        teamService.retrieveTeams().forEach(t -> System.out.println(t.getTeamTitle() + " " + t.getTeamCity()));

//        model.put("teams", teamService.retrieveTeams());
        return "redirect:/schedule";
    }
}
