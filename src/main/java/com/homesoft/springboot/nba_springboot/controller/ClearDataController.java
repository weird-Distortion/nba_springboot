package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.service.AutoDataService;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClearDataController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private AutoDataService autoDataService;

    @RequestMapping(value = "/clear-data", method = RequestMethod.GET)
    public String showClearDataPage(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());

        return "clear-data";
    }

    @RequestMapping(value = "/clear-data", method = RequestMethod.POST)
    public String clearData(ModelMap model) {
        autoDataService.clearTable();
        return "redirect:/schedule";
    }
}
