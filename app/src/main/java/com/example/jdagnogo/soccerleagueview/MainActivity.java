package com.example.jdagnogo.soccerleagueview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jdagnogo.soccerleagueviewlib.SoccerLeagueView;
import com.example.jdagnogo.soccerleagueviewlib.models.Match;
import com.example.jdagnogo.soccerleagueviewlib.models.Team;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Team> teams = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTeams();
        SoccerLeagueView soccerLeagueView = (SoccerLeagueView) findViewById(R.id.soccer);
        soccerLeagueView.addTeam(teams);
        soccerLeagueView.startLeague();
        soccerLeagueView.addMatch(new Match(teams.get(1),teams.get(1),1,1));
        soccerLeagueView.addMatch(new Match(teams.get(1),teams.get(0),1,1));
        soccerLeagueView.addMatch(new Match(teams.get(1),teams.get(2),1,4));
        soccerLeagueView.addMatch(new Match(teams.get(1),teams.get(2),2,4));
        soccerLeagueView.addMatch(new Match(teams.get(2),teams.get(1),2,4));
        soccerLeagueView.addMatch(new Match(teams.get(2),teams.get(1),2,4));

    }

    private void initTeams() {
        /*Team arsenal = new Team("Arsenal", "Ars");
        Team manchester = new Team("Manchester Utd", "Utd");
        Team chelsea = new Team("Chelsea", "CHE");
        Team tot = new Team("Totenham", "TOT");
       */
       for( int i =0; i<3;i++){
           Team team = new Team("team"+i,"t"+i);
           teams.add(team);
       }
    }
}
