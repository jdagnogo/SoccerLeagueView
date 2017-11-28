package com.example.jdagnogo.soccerleagueviewlib.models;

import java.util.HashMap;

public class TeamInLeague {

    int currentPoints = 0;
    Team team;
    int numberOfMatchPlayed = 0;
    int numberOfmatchWin = 0;
    int numberOfmatchDraw = 0;
    int numberOfmatchLost = 0;
    int goalScored = 0;
    int goalConceded = 0;
    int diff = 0;
    private HashMap<String, Match> matchAlreadyPlayed;

    public TeamInLeague(Team team) {
        this.team = team;
        currentPoints = 0;
        matchAlreadyPlayed = new HashMap<>();

    }

    public HashMap<String, Match> getMatchAlreadyPlayed() {
        return matchAlreadyPlayed;
    }

    public void setMatchAlreadyPlayed(HashMap<String, Match> matchAlreadyPlayed) {
        this.matchAlreadyPlayed = matchAlreadyPlayed;
    }

    public void updateHomeMatch(Match match) {
      updateMatch(match.scoreHome,match.scoreAway);
        getMatchAlreadyPlayed().put(match.generateId(match.home, match.away), match);
    }
    public void updateAwayMatch(Match match) {
        updateMatch(match.scoreAway,match.scoreHome);
        getMatchAlreadyPlayed().put(match.generateId(match.home, match.away), match);

    }
    private void updateMatch(int matchScoreHome, int matchScoreAway){
        numberOfMatchPlayed++;
        setGoalConceded(goalConceded + matchScoreAway);
        setGoalScored(goalScored + matchScoreHome);

        if (matchScoreHome> matchScoreAway){
            numberOfmatchWin ++;
            currentPoints = currentPoints+3;
        }else if (matchScoreHome< matchScoreAway){
            numberOfmatchLost ++;
        }else {
            numberOfmatchDraw ++;
            currentPoints ++;
        }
        updateDiff();
    }

    private void updateDiff(){
        diff = goalScored-goalConceded;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public int getGoalConceded() {
        return goalConceded;
    }

    public void setGoalConceded(int goalConceded) {
        this.goalConceded = goalConceded;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getNumberOfMatchPlayed() {
        return numberOfMatchPlayed;
    }

    public void setNumberOfMatchPlayed(int numberOfMatchPlayed) {
        this.numberOfMatchPlayed = numberOfMatchPlayed;
    }

    public int getNumberOfmatchWin() {
        return numberOfmatchWin;
    }

    public void setNumberOfmatchWin(int numberOfmatchWin) {
        this.numberOfmatchWin = numberOfmatchWin;
    }

    public int getNumberOfmatchDraw() {
        return numberOfmatchDraw;
    }

    public void setNumberOfmatchDraw(int numberOfmatchDraw) {
        this.numberOfmatchDraw = numberOfmatchDraw;
    }

    public int getNumberOfmatchLost() {
        return numberOfmatchLost;
    }

    public void setNumberOfmatchLost(int numberOfmatchLost) {
        this.numberOfmatchLost = numberOfmatchLost;
    }
}
