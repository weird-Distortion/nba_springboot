package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularSeason {

    @Autowired
    private DivisionGames divisionGames;

    @Autowired
    private CrossDivisionGames crossDivisionGames;

    @Autowired
    private CrossConferenceGames crossConferenceGames;

    public RegularSeason() {}

    public void playRegularSeasonGames(Conference east, Conference west) {
        serveDivisionGames(east);
        serveDivisionGames(west);
        crossDivisionGames.playCrossDivisionGames(east.getConferenceDivisions());
        crossDivisionGames.playCrossDivisionGames(west.getConferenceDivisions());
        crossConferenceGames.playCrossConfGames(east, west);
    }

    private void serveDivisionGames(Conference conference) {
        conference.getConferenceDivisions()
                .forEach(division ->
                        divisionGames.playDivisionGames(division));
    }
}
