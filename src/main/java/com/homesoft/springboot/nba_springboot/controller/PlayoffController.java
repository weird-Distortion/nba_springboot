package com.homesoft.springboot.nba_springboot.controller;

import com.homesoft.springboot.nba_springboot.model.Conference;
import com.homesoft.springboot.nba_springboot.model.Team;
import com.homesoft.springboot.nba_springboot.service.ConferenceService;
import com.homesoft.springboot.nba_springboot.service.PlayoffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
@SessionAttributes("champs")
public class PlayoffController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private PlayoffService playoffService;

    @ModelAttribute("champs")
    public List<Team> setUpChampList() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/playoff", method = RequestMethod.GET)
    public String showPlayoffPage(ModelMap model) {
        model.addAttribute("westTeams",
                conferenceService
                        .getConferenceById(1)
                        .getConferencePlayoffTeams());

        model.addAttribute("eastTeams",
                conferenceService
                        .getConferenceById(2)
                        .getConferencePlayoffTeams());

        return "playoff";
    }

    @RequestMapping(value = "/playoff", method = RequestMethod.POST)
    public String playPlayoff(
            @ModelAttribute("champs") List<Team> champList,
            ModelMap model) {
        List<List<Team>> westSchedule =
                playoffService
                        .makeConferenceSchedule(conferenceService
                                .getConferenceById(1)
                                .getConferencePlayoffTeams());

        List<List<Team>> eastSchedule =
                playoffService
                        .makeConferenceSchedule(conferenceService
                                .getConferenceById(2)
                                .getConferencePlayoffTeams());

        Conference west = conferenceService.getConferenceById(1);
        Conference east = conferenceService.getConferenceById(2);

        model.addAttribute("westTeams", west.getConferencePlayoffTeams());
        model.addAttribute("eastTeams", east.getConferencePlayoffTeams());

        List<Team> westFirstRound = playoffService.playPlayoffFirstRound(westSchedule);
        List<Team> eastFirstRound = playoffService.playPlayoffFirstRound(eastSchedule);

        List<Team> westSecondRound = playoffService.playPlayoffGames(westFirstRound);
        List<Team> eastSecondRound = playoffService.playPlayoffGames(eastFirstRound);

        List<Team> westThirdRound = playoffService.playPlayoffGames(westSecondRound);
        List<Team> eastThirdRound = playoffService.playPlayoffGames(eastSecondRound);

        model.addAttribute("westFirstRound", westFirstRound);
        model.addAttribute("eastFirstRound", eastFirstRound);
        model.addAttribute("westSecondRound", westSecondRound);
        model.addAttribute("eastSecondRound", eastSecondRound);
        model.addAttribute("westThirdRound", westThirdRound.get(0));
        model.addAttribute("eastThirdRound", eastThirdRound.get(0));

        champList.addAll(asList(westThirdRound.get(0), eastThirdRound.get(0)));

        return "playoff";
    }
}
