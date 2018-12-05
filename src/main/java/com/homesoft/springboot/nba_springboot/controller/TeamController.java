package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.DivisionService;
import com.homesoft.springboot.nba_springboot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private DivisionService divisionService;

    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public String addNewTeam(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());
        model.addAttribute("division", divisionService.findAllDivisions());
        model.addAttribute("team", new Team());
        return "new-team";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.POST)
    public String addTeam(ModelMap model, Team newTeam) {
        teamService.persistTeam(newTeam);
        return "redirect:/schedule";
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public String showTeamInfo(ModelMap model, @RequestParam int id) {
        Team team = teamService.findTeamById(id);
        model.addAttribute("team", team);
        model.addAttribute("conference", team.getTeamConference());
        model.addAttribute("division", team.getTeamDivision());
        model.put("players", team.getTeamPlayers());
        return "team";
    }
}
