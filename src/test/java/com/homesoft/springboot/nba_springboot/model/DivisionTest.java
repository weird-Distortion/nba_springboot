package com.homesoft.springboot.nba_springboot.model;

import com.homesoft.springboot.nba_springboot.dao.DivisionDAO;
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
public class DivisionTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DivisionDAO divisionDAO;

    private Division testDivision;

    @Before
    public void setUp() throws Exception {
        Conference testConference = new Conference();
        testDivision = new Division();
        testDivision.setDivisionTitle("testDivisionTitle");
        testDivision.setDivisionConference(testConference);
        testEntityManager.persistAndFlush(testConference);
        testEntityManager.persistAndFlush(testDivision);
    }

    @Test
    public void findByDivisionTitle_returnDivision() {
        Division foundDivision = divisionDAO.findByDivisionTitle(testDivision.getDivisionTitle());

        assertThat(foundDivision.getDivisionTitle()).isEqualTo(testDivision.getDivisionTitle());
    }
}