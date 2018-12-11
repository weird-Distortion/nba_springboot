package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import com.homesoft.springboot.nba_springboot.model.Conference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceDAO conferenceDAO;

    public Conference getConferenceById(int conferenceId) {
        return conferenceDAO.getOne(conferenceId);
    }

    public List<Conference> findAllConferences() {
        return conferenceDAO.findAll();
    }

    public void persistConference(Conference conference) {
        if (conferenceDAO.findAll().size() < 2)
            conferenceDAO.save(conference);
    }

    public Conference createNewConference() {
        return new Conference();
    }
}
