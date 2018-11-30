package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is just about playing division games due NBA logic
 */
@Service
public class DivisionGames {

    @Autowired
    private RegularSeasonGameService regularSeasonGameService;

    public void playDivisionGames(Division division) {

        assert division != null;
        int counter = 0;
        System.out.println(regularSeasonGameService.toString() + " GAME SERVICE IS NOT NULL!!!!!!   ");
        while (counter < division.getDivisionTeams().size() - 1) {
            division.getDivisionTeams()
                    .forEach(teamA ->
                            division.getDivisionTeams()
                                    .stream()
                                    .skip(division.getDivisionTeams().indexOf(teamA) + 1)
                                    .forEach(teamB ->
                                            regularSeasonGameService.playMatch(teamA, teamB)));

            counter++;
        }

    }
}
