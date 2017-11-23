package com.example.jdagnogo.soccerleagueview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jdagnogo.soccerleagueviewlib.SoccerLeagueView;
import com.example.jdagnogo.soccerleagueviewlib.models.Team;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoccerLeagueView soccerLeagueView = (SoccerLeagueView) findViewById(R.id.soccer);
        soccerLeagueView.addTeam(initTeams());
        soccerLeagueView.startLeague();


    }

    private ArrayList<Team> initTeams() {
        Team arsenal = new Team("Arsenal", "Ars");
        Team manchester = new Team("Manchester Utd", "Utd");
        Team chelsea = new Team("Chelsea", "CHE");
        Team tot = new Team("Totenham", "TOT");


        ArrayList<Team> teams = new ArrayList<>();
        teams.add(arsenal);
        teams.add(chelsea);
        teams.add(tot);
        teams.add(manchester);
        return teams;
    }
}
