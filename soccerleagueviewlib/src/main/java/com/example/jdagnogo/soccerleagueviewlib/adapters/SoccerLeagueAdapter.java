package com.example.jdagnogo.soccerleagueviewlib.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jdagnogo.soccerleagueviewlib.R;
import com.example.jdagnogo.soccerleagueviewlib.models.TeamInLeague;

import java.util.ArrayList;

public class SoccerLeagueAdapter extends RecyclerView.Adapter<SoccerLeagueAdapter.SoccerLeagueAdapterViewHolder> {
    private ArrayList<TeamInLeague> mDataset;
    private Context context;

    public SoccerLeagueAdapter(ArrayList<TeamInLeague> mDataset, Context context) {
        this.mDataset = mDataset;
        this.context = context;
    }


    @Override
    public SoccerLeagueAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.soccer_league_item, parent, false);
        return new SoccerLeagueAdapter.SoccerLeagueAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SoccerLeagueAdapterViewHolder holder, int position) {
        holder.teamName.setText(mDataset.get(position).getTeam().getName());
        holder.rank.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }


    public class SoccerLeagueAdapterViewHolder extends RecyclerView.ViewHolder {
        final TextView teamName;
        final TextView rank;

        public SoccerLeagueAdapterViewHolder(View itemView) {
            super(itemView);
            teamName = (TextView) itemView.findViewById(R.id.team_name);
            rank = (TextView) itemView.findViewById(R.id.rank);
        }
    }
}
