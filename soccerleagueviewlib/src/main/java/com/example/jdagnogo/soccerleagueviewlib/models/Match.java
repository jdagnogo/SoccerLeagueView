package com.example.jdagnogo.soccerleagueviewlib.models;

public class Match {
    Team home;
    Team away;
    int scoreHome;
    int scoreAway;
    boolean isOver = false;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }
}
