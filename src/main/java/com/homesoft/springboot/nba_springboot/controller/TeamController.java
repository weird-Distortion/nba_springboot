package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.dao.DivisionDAO;
import com.homesoft.springboot.nba_springboot.dao.PlayerDAO;
import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.model.Player;
import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private ConferenceDAO conferenceDAO;

    @Autowired
    private DivisionDAO divisionDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {
        model.put("conferences", conferenceDAO.findAll());
        return "schedule";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.GET)
    public String addNewTeam(ModelMap model) {
        model.addAttribute("conference", conferenceDAO.findAll());
        model.addAttribute("division", divisionDAO.findAll());
        model.addAttribute("team", new Team());
        return "new-team";
    }

    @RequestMapping(value = "/new-team", method = RequestMethod.POST)
    public String addTeam(ModelMap model, Team newTeam) {
        teamDAO.save(newTeam);
        return "redirect:/schedule";
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public String showTeamInfo(ModelMap model, @RequestParam int id) {
        Team team = teamDAO.findById(id).get();
        model.addAttribute("teamAttribute", team);
        model.addAttribute("conference", team.getTeamConference());
        model.addAttribute("division", team.getTeamDivision());
        model.put("players", team.getTeamPlayers());
        return "team";
    }

    //HOW TO UPDATE DIVISION?
//    @RequestMapping(value = "/team", method = RequestMethod.POST)
//    public String saveTeam(ModelMap model, Team team, @RequestParam int id) {
//        teamDAO.deleteById(id);
//        teamDAO.save(team);
//        return "redirect:/schedule";
//    }
}
