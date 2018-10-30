package com.homesoft.springboot.nba_springboot.model;

public class Team {
    private int id;
    private String title;
    private String city;
    // private Conference conference;

    public Team(int id, String title, String city) {
        super();
        this.id = id;
        this.title = title;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
