package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.service.AutoDataService;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AutofillController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private AutoDataService autoDataService;

    @RequestMapping(value = "/autofill", method = RequestMethod.GET)
    public String showAutofillPage(ModelMap model) {
        model.addAttribute("conferences", conferenceService.findAllConferences());

        return "autofill";
    }

    @RequestMapping(value = "/autofill", method = RequestMethod.POST)
    public String autofillTable(ModelMap model) {

        autoDataService.autofillTable();
        return "redirect:/schedule";
    }
}
