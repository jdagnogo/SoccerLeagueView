package com.example.jdagnogo.soccerleagueviewlib.models;

import java.util.ArrayList;
import java.util.HashMap;


public class League {

    private ArrayList<TeamInLeague> teams;
    private boolean isStarted = false;
    private HashMap<String, Match> matchAlreadyPlayed;
    private int numberOfMatchesByTeams;
    private boolean isHomeAway = true;

    public League(boolean isHomeAway) {
        this.isHomeAway = isHomeAway;

    }

    private void startTournament() {
        isStarted = true;
        numberOfMatchesByTeams = generateNumberOfMatchesByTeams();
    }

    public void addATeam(Team team){
        TeamInLeague teamInLeague= new TeamInLeague(team);
        teams.add(teamInLeague);
    }

    private int generateNumberOfMatchesByTeams() {
        int number = teams.size() - 1;
        if (isHomeAway)
            return number * 2;
        else
            return number;
    }

    public ArrayList<TeamInLeague> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<TeamInLeague> teams) {
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
