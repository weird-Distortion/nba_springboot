package com.homesoft.springboot.nba_springboot.dao;

import com.homesoft.springboot.nba_springboot.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionDAO extends JpaRepository<Division, Integer> {
    Division findByDivisionTitle(String divisionTitle);
}
