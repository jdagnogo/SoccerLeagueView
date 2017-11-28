package com.example.jdagnogo.soccerleagueviewlib.models;

import java.util.ArrayList;
import java.util.HashMap;


public class League {

    private HashMap<String, TeamInLeague> teams;
    private boolean isStarted = false;
    private HashMap<String, Match> matchAlreadyPlayed;
    private int numberOfMatchesByTeams;
    private boolean isHomeAway = true;
    private String name;

    public League(boolean isHomeAway) {
        teams = new HashMap<>();
        matchAlreadyPlayed = new HashMap<>();
        this.isHomeAway = isHomeAway;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        TeamInLeague home = teams.get(match.getHome().getShortName());
        TeamInLeague away = teams.get(match.getAway().getShortName());
        if (null != home && null != away) {
            //teams exist
            String matchId = match.generateId(home.getTeam(), away.getTeam());
            Match match1 = matchAlreadyPlayed.get(matchId);
            if (null == match1) {
                // match not alerady played
                if (!home.equals(away)) {
                    //not the same team twice
                    home.updateHomeMatch(match);
                    away.updateAwayMatch(match);
                    teams.put(home.getTeam().getShortName(), home);
                    teams.put(away.getTeam().getShortName(), away);
                    matchAlreadyPlayed.put(matchId, match);
                }
            }
        }
    }


    public void startTournament() {
        isStarted = true;
        numberOfMatchesByTeams = generateNumberOfMatchesByTeams();
    }

    public void addATeam(Team team) {
        TeamInLeague teamInLeague = new TeamInLeague(team);
        teams.put(team.getShortName(), teamInLeague);
    }

    private int generateNumberOfMatchesByTeams() {
        int number = teams.size() - 1;
        if (isHomeAway)
            return number * 2;
        else
            return number;
    }

    public HashMap<String, TeamInLeague> getTeams() {
        return teams;
    }

    public void setTeams(HashMap<String, TeamInLeague> teams) {
        this.teams = teams;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public HashMap<String, Match> getMatchAlreadyPlayed() {
        return matchAlreadyPlayed;
    }

    public void setMatchAlreadyPlayed(HashMap<String, Match> matchAlreadyPlayed) {
        this.matchAlreadyPlayed = matchAlreadyPlayed;
    }

    public int getNumberOfMatchesByTeams() {
        return numberOfMatchesByTeams;
    }

    public void setNumberOfMatchesByTeams(int numberOfMatchesByTeams) {
        this.numberOfMatchesByTeams = numberOfMatchesByTeams;
    }

    public boolean isHomeAway() {
        return isHomeAway;
    }

    public void setHomeAway(boolean homeAway) {
        isHomeAway = homeAway;
    }
}
