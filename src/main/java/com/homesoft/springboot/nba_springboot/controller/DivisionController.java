package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Division;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.DivisionService;
import com.homesoft.springboot.nba_springboot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DivisionController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private ConferenceService conferenceService;

    @RequestMapping(value = "/new-division", method = RequestMethod.GET)
    public String addNewDivision(ModelMap model) {

        model.addAttribute("division", new Division());
        model.addAttribute("conference", conferenceService.findAllConferences());
        model.addAttribute("team", teamService.findAllTeams());
        return "new-division";
    }

    @RequestMapping(value = "/new-division", method = RequestMethod.POST)
    public String addDivision(ModelMap model, Division newDivision) {
        divisionService.persistDivision(newDivision);
        return "redirect:/schedule";
    }
}
