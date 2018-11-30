package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Class is about to play games with teams that belong to another Conference due NBA logic.
 */
@Service
public class CrossConferenceGames {

    @Autowired
    private RegularSeasonGameService regularSeasonGameService;

    public void playCrossConfGames(Conference east, Conference west) {
        int counter = 0;

        while (counter < 2) {
            east.getConferenceTeams()
                    .forEach(eastTeam ->
                            west.getConferenceTeams()
                                    .forEach(westTeam -> regularSeasonGameService.playMatch(eastTeam, westTeam)));

            counter++;
        }
    }
}
