package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
public class FinalsController {

    @RequestMapping(value = "/finals", method = RequestMethod.GET)
    public String showFinalsPage(
            @SessionAttribute("champs") List<Team> champList,
            ModelMap model) {

        model.addAttribute("champions", champList);
        //TODO: add ConferenceWinner to Conference entity to display it on finals page

        return "finals";
    }
}
