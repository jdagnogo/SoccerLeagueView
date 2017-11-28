package com.example.jdagnogo.soccerleagueviewlib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdagnogo.soccerleagueviewlib.adapters.SoccerLeagueAdapter;
import com.example.jdagnogo.soccerleagueviewlib.models.League;
import com.example.jdagnogo.soccerleagueviewlib.models.Match;
import com.example.jdagnogo.soccerleagueviewlib.models.Team;
import com.example.jdagnogo.soccerleagueviewlib.models.TeamInLeague;

import java.util.ArrayList;

public class SoccerLeagueView extends LinearLayout implements View.OnClickListener {

    View rootView;
    private League league;
    private Context context;
    private RecyclerView recyclerView;
    private SoccerLeagueAdapter adapter;
    private TextView mj, g, n, p, bm, be, diff, pts, name;

    public SoccerLeagueView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupLayout(context);
        league = new League(true);
        initViews();
        updateElementsAccordingToAttributs(context, attrs);
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    private void initTextviews() {
        mj = (TextView) rootView.findViewById(R.id.mj);
        g = (TextView) rootView.findViewById(R.id.g);
        n = (TextView) rootView.findViewById(R.id.n);
        p = (TextView) rootView.findViewById(R.id.p);
        bm = (TextView) rootView.findViewById(R.id.bm);
        be = (TextView) rootView.findViewById(R.id.be);
        diff = (TextView) rootView.findViewById(R.id.diff);
        pts = (TextView) rootView.findViewById(R.id.pts);
        name = (TextView) rootView.findViewById(R.id.name);
        name.setText(league.getName());

        mj.setOnClickListener(this);
        g.setOnClickListener(this);
        p.setOnClickListener(this);
        n.setOnClickListener(this);
        be.setOnClickListener(this);
        bm.setOnClickListener(this);
        diff.setOnClickListener(this);
        pts.setOnClickListener(this);
    }

    public void addMatch(Match match) {
        league.addMatch(match);
        ArrayList<TeamInLeague> list = new ArrayList<TeamInLeague>(league.getTeams().values());
        adapter.setDataSet(list);
    }

    public void addMatch(ArrayList<Match> matchs) {
        for (Match match : matchs) {
            league.addMatch(match);
        }
        ArrayList<TeamInLeague> list = new ArrayList<TeamInLeague>(league.getTeams().values());
        adapter.setDataSet(list);
    }

    private void updateElementsAccordingToAttributs(Context context, AttributeSet attrs) {

    }

    public void startLeague(String name) {
        this.name.setText(name);
        league.setName(name);
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

    private void resetTextViewColors() {
        mj.setTextColor(getResources().getColor(R.color.defaut_black));
        g.setTextColor(getResources().getColor(R.color.defaut_black));
        p.setTextColor(getResources().getColor(R.color.defaut_black));
        n.setTextColor(getResources().getColor(R.color.defaut_black));
        be.setTextColor(getResources().getColor(R.color.defaut_black));
        bm.setTextColor(getResources().getColor(R.color.defaut_black));
        pts.setTextColor(getResources().getColor(R.color.defaut_black));
        diff.setTextColor(getResources().getColor(R.color.defaut_black));
    }

    private void setTextViewSelected(TextView textViewSelected) {
        textViewSelected.setTextColor(getResources().getColor(R.color.secondaryDark));
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
        initTextviews();
    }

    public void setupLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.main_view, this);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        resetTextViewColors();
        if (i == R.id.mj) {
            setTextViewSelected(mj);
        } else if (i == R.id.g) {
            setTextViewSelected(g);
        } else if (i == R.id.n) {
            setTextViewSelected(n);
        } else if (i == R.id.p) {
            setTextViewSelected(p);
        } else if (i == R.id.bm) {
            setTextViewSelected(bm);
        } else if (i == R.id.be) {
            setTextViewSelected(be);
        } else if (i == R.id.diff) {
            setTextViewSelected(diff);
        } else if (i == R.id.pts) {
            setTextViewSelected(pts);
        }
        adapter.order(i);
    }
}
