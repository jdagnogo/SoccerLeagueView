package com.example.jdagnogo.soccerleagueviewlib.models.Enum;

public enum MatchResultEnum {
    VICTORY(3),
    DRAW(1),
    DEFEAT(0);

    private int points;

    MatchResultEnum(int points) {
        this.points = points;
    }

    public int getPoints(){
        return points;
    }
}
