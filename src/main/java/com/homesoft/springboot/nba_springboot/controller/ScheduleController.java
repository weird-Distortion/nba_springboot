package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.service.RegularSeason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScheduleController {

    @Autowired
    private ConferenceDAO conferenceDAO;

    @Autowired
    private RegularSeason regularSeason;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(ModelMap model) {
        model.put("conferences", conferenceDAO.findAll());
        return "schedule";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public String playRegularSeason(ModelMap model) {
        regularSeason.playRegularSeasonGames(conferenceDAO.getOne(1), conferenceDAO.getOne(2));
        model.addAttribute("conf", conferenceDAO.findAll());
        model.put("conferences", conferenceDAO.findAll());
        return "schedule";
    }
}
