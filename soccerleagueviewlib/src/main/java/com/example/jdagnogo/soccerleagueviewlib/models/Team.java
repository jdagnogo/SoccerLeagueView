package com.example.jdagnogo.soccerleagueviewlib.models;

public class Team {
    String name;
    String shortName;


    public Team(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
