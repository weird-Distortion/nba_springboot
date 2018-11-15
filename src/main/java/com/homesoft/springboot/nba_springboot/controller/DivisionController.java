package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.dao.DivisionDAO;
import com.homesoft.springboot.nba_springboot.dao.TeamDAO;
import com.homesoft.springboot.nba_springboot.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DivisionController {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private DivisionDAO divisionDAO;

    @Autowired
    private ConferenceDAO conferenceDAO;

    @RequestMapping(value = "/new-division", method = RequestMethod.GET)
    public String addNewDivision(ModelMap model) {

        model.addAttribute("division", new Division());
        model.addAttribute("conference", conferenceDAO.findAll());
        model.addAttribute("team", teamDAO.findAll());
        return "new-division";
    }

    @RequestMapping(value = "/new-division", method = RequestMethod.POST)
    public String addDivision(ModelMap model, Division newDivision) {
        divisionDAO.save(newDivision);
        return "redirect:/schedule";
    }
}
