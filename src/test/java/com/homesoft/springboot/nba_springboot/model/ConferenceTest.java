package com.homesoft.springboot.nba_springboot.model;

import com.homesoft.springboot.nba_springboot.dao.ConferenceDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConferenceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ConferenceDAO conferenceDAO;

    private Conference testConference;

    @Before
    public void setUp() throws Exception {
        testConference = new Conference();
        testConference.setConferenceId(5);
        testConference.setConferenceTitle("testConference");
    }

    @Test
    public void whenFindByConferenceName_returnConference() {
        testEntityManager.merge(testConference);

        Conference foundConference = conferenceDAO.findByConferenceTitle(testConference.getConferenceTitle());

        assertThat(foundConference.getConferenceTitle()).isEqualTo(testConference.getConferenceTitle());
    }
}