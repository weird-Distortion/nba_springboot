package com.homesoft.springboot.nba_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayoffController {

    @RequestMapping(value = "/playoff", method = RequestMethod.GET)
    public String showPlayoffPage(ModelMap model) {

        return "playoff";
    }
}
