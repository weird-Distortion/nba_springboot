package com.homesoft.springboot.nba_springboot.service;

import com.homesoft.springboot.nba_springboot.dao.DivisionDAO;
import com.homesoft.springboot.nba_springboot.model.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {

    @Autowired
    private DivisionDAO divisionDAO;

    public void persistDivision(Division division) {
        divisionDAO.save(division);
    }

    public List<Division> findAllDivisions() {
        return divisionDAO.findAll();
    }

    public Division createNewDivision() {
        return new Division();
    }
}
