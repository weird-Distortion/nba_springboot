package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    private String playerFirstName;
    private String playerLastName;
    private int playerNumber;
    private double playerAttackRate;
    private double playerDefenceRate;
    private double playerThreePointRate;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team playerTeam;

    public Player() {
        super();
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public double getPlayerAttackRate() {
        return playerAttackRate;
    }

    public double getPlayerDefenceRate() {
        return playerDefenceRate;
    }

    public double getPlayerThreePointRate() {
        return playerThreePointRate;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }
}
