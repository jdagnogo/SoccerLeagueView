package com.example.jdagnogo.soccerleagueviewlib.models;

import com.example.jdagnogo.soccerleagueviewlib.models.Enum.MatchLocationEnum;
import com.example.jdagnogo.soccerleagueviewlib.models.Enum.MatchResultEnum;

import static com.example.jdagnogo.soccerleagueviewlib.models.Enum.MatchLocationEnum.AWAY;
import static com.example.jdagnogo.soccerleagueviewlib.models.Enum.MatchLocationEnum.HOME;

public class Match {
    Team home;
    String id;
    Team away;
    int scoreHome;
    int scoreAway;
    boolean isOver = false;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
        id = generateId(home, away);
    }

    public Match(Team home, Team away, int scoreHome, int scoreAway) {
        this.home = home;
        this.away = away;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        isOver = true;
        id = generateId(home, away);
    }

    public static String generateId(Team home, Team away) {
        return String.format("%s%s", home.getName(), away.getName());
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(int scoreHome) {
        this.scoreHome = scoreHome;
    }

    public int getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(int scoreAway) {
        this.scoreAway = scoreAway;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }
}
