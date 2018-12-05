package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceDAO extends JpaRepository<Conference, Integer> {
    Conference findByConferenceTitle(String conferenceTitle);
}
