package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Division;
import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Class is about to play games with teams that belong to different divisions due NBA logic.
 */
@Service
public class CrossDivisionGames {

    @Autowired
    private RegularSeasonGameService regularSeasonGameService;

    /**
     * Each division splits for 2 lists. First list contains first 3 teams,
     * second list contains rest 2 teams of each division.
     * This kind of not really clever logic
     * uses for making game schedule in the NBA conference.
     */
    public void playCrossDivisionGames(List<Division> divisions) {

        List<List<Team>> tripleTeamList =
                divisions
                        .stream()
                        .map(division ->
                                division.getDivisionTeams()
                                        .stream()
                                        .limit(3)
                                        .collect(toList()))
                        .collect(toList());

        List<List<Team>> doubleTeamList =
                divisions
                        .stream()
                        .map(division ->
                                division.getDivisionTeams()
                                        .stream()
                                        .skip(3)
                                        .limit(2)
                                        .collect(toList()))
                        .collect(toList());

        playAgainstSixTeams(tripleTeamList);
        playAgainstSixTeams(doubleTeamList);
        playAgainstFourTeams(tripleTeamList, doubleTeamList);
        playRestGames(doubleTeamList);
    }

    private void playAgainstSixTeams(List<List<Team>> list) {
        int counter = 0;
        while (counter < 4) {
            list.forEach(arrayA ->
                    list.stream()
                            .skip(list.indexOf(arrayA) + 1)
                            .forEach(arrayB ->
                                    arrayA.forEach(teamA ->
                                            arrayB.forEach(teamB ->
                                                    regularSeasonGameService.playMatch(teamA, teamB)))));

            counter++;
        }
    }

    private void playAgainstFourTeams(List<List<Team>> triplesList, List<List<Team>> doublesList) {
        int counter = 0;

        while (counter < 3) {
            triplesList
                    .forEach(arrayA ->
                            arrayA.forEach(teamA ->
                                    doublesList
                                            .stream()
                                            .flatMap(array ->
                                                    array.stream()
                                                            .filter(someTeam ->
                                                                    !someTeam.getTeamDivision()
                                                                            .getDivisionTitle()
                                                                            .equals(arrayA.get(0)
                                                                                    .getTeamDivision()
                                                                                    .getDivisionTitle())))
                                            .collect(toList())
                                            .forEach(teamB ->
                                                    regularSeasonGameService.playMatch(teamA, teamB))));

            counter++;
        }
    }

    private void playRestGames(List<List<Team>> list) {
        list.forEach(arrayA ->
                arrayA.forEach(teamA ->
                        list.stream()
                                .skip(list.indexOf(arrayA) + 1)
                                .forEach(arrayB ->
                                        arrayB.stream()
                                                .skip(arrayA.indexOf(teamA))
                                                .limit(1)
                                                .forEach(teamB -> regularSeasonGameService.playMatch(teamA, teamB)))));
    }
}
