package com.homesoft.springboot.nba_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController implements NbaController {

    @RequestMapping(value = "/index")
    public String showRegularSeason() {

        return "index";
    }

}
