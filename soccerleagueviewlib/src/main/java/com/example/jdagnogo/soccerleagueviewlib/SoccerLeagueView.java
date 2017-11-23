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
import com.example.jdagnogo.soccerleagueviewlib.models.Team;

import java.util.ArrayList;

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

    private void updateElementsAccordingToAttributs(Context context, AttributeSet attrs) {

    }

    public void startLeague() {
        if (league.getTeams().size() < 2) {
            //TODO show toast
        } else {
            league.setStarted(true);
            initViews();
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
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new SoccerLeagueAdapter(league.getTeams(), context);
        recyclerView.setAdapter(adapter);
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
