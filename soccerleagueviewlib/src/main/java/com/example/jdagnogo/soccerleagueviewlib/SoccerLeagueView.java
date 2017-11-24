package com.example.jdagnogo.soccerleagueviewlib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jdagnogo.soccerleagueviewlib.adapters.SoccerLeagueAdapter;
import com.example.jdagnogo.soccerleagueviewlib.models.League;
import com.example.jdagnogo.soccerleagueviewlib.models.Match;
import com.example.jdagnogo.soccerleagueviewlib.models.Team;
import com.example.jdagnogo.soccerleagueviewlib.models.TeamInLeague;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerLeagueView extends LinearLayout {

    View rootView;
    League league;
    private Context context;
    private RecyclerView recyclerView;
    private SoccerLeagueAdapter adapter;

    public SoccerLeagueView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupLayout(context);
        league = new League(true);
        initViews();
        updateElementsAccordingToAttributs(context, attrs);
    }

    public void addMatch(Match match) {
        league.addMatch(match);
        ArrayList<TeamInLeague> list = new ArrayList<TeamInLeague>(league.getTeams().values());
        adapter.setDataSet(list);
    }

    private void updateElementsAccordingToAttributs(Context context, AttributeSet attrs) {

    }

    public void startLeague() {
        if (league.getTeams().size() < 2) {
            //TODO show toast
        } else {
            league.startTournament();
            initViews();
            intiAdapter();
        }

    }

    public void addTeam(Team team) {
        league.addATeam(team);
    }

    public void addTeam(ArrayList<Team> teams) {
        for (Team team : teams) {
            league.addATeam(team);
        }
    }

    private void intiAdapter() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        ArrayList<TeamInLeague> list = new ArrayList<TeamInLeague>(league.getTeams().values());
        adapter = new SoccerLeagueAdapter(list, context);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initViews() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
    }

    public void setupLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.main_view, this);

    }
}
