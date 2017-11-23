package com.example.jdagnogo.soccerleagueviewlib.models;

public class TeamInLeague {

    int currentPoints;
    Team team;
    int numberOfMatchPlayed = 0;
    int numberOfmatchWin = 0;
    int numberOfmatchDraw = 0;
    int numberOfmatchLost = 0;

    public TeamInLeague(Team team) {
        this.team = team;
        currentPoints =0;

    }

    public void updateScore(Match match){
        numberOfMatchPlayed ++;
        //currentPoints+=matchResult.getPoints();
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
