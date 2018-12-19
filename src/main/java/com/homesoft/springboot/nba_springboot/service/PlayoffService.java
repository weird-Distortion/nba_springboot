package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class PlayoffService {

    @Autowired
    private PlayoffGameService playoffGameService;

    public List<Team> playPlayoffFirstRound(List<List<Team>> teams) {

        return teams
                .stream()
                .map(pair ->
                        playoffGameService.playMatch(pair.get(0), pair.get(1)))
                .collect(toList());
    }

    public List<Team> playPlayoffGames(List<Team> teams) {

        List<Team> result = new ArrayList<>();

        for (int i = 0; i < teams.size() - 1; i += 2) {
            result.add(playoffGameService.playMatch(teams.get(i), teams.get(i + 1)));
        }

        return result;
    }

    public List<List<Team>> makeConferenceSchedule(List<Team> teamList) {
        List<List<Team>> schedule = new ArrayList<>();

        for (int i = 0; i < teamList.size() / 2; i++) {
            schedule.add(List.of(teamList.get(i), teamList.get(teamList.size() - i - 1)));
        }

        return schedule;
    }
}
