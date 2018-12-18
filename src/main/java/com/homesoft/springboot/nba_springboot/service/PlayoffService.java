package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PlayoffService {

    @Autowired
    private PlayoffGameService playoffGameService;

    public Team playPlayoffGames(List<Team> teams) {
        List<Team> result = new ArrayList<>(teams);

        while (result.size() != 1) {

            List<List<Team>> schedule = makeConferenceSchedule(result);

            result.clear();
            result = schedule
                    .stream()
                    .map(pair ->
                            playoffGameService.playMatch(pair.get(0), pair.get(1)))
                    .collect(toList());
        }

        return result.get(0);
    }

    private List<List<Team>> makeConferenceSchedule(List<Team> teamList) {
        List<List<Team>> schedule = new ArrayList<>();

        for (int i = 0; i < teamList.size() / 2; i++) {
            schedule.add(List.of(teamList.get(i), teamList.get(teamList.size() - i - 1)));
        }

        return schedule;
    }
}
