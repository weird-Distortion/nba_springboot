package com.homesoft.springboot.nba_springboot.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column
    private String playerFirstName;

    @Column
    private String playerLastName;

    @Column
    private int playerNumber;

    @Column
    private double playerAttackRate;

    @Column
    private double playerDefenceRate;

    @Column
    private double playerLongShotRate;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team playerTeam;

    public Player() {
        super();
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public void setPlayerAttackRate(double playerAttackRate) {
        this.playerAttackRate = playerAttackRate;
    }

    public double getPlayerDefenceRate() {
        return playerDefenceRate;
    }

    public void setPlayerDefenceRate(double playerDefenceRate) {
        this.playerDefenceRate = playerDefenceRate;
    }

    public double getPlayerLongShotRate() {
        return playerLongShotRate;
    }

    public void setPlayerLongShotRate(double playerLongShotRate) {
        this.playerLongShotRate = playerLongShotRate;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }
}
