package com.pratap.ninja.soundcheck.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.pratap.ninja.soundcheck.R;
import com.pratap.ninja.soundcheck.models.Sound;

import java.util.ArrayList;

/**
 * Created by darsh on 6/12/17.
 */

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder> {

    private Context context;
    private ArrayList<Sound> tracks = new ArrayList<>();
    private static final String TAG = "NL";

    public SoundAdapter(Context context) {
        this.context = context;
    }

    public void updateTracks(ArrayList<Sound> tracks) {
        Log.d(TAG, "updateNews: " + tracks.size());
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    @Override
    public SoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new SoundViewHolder(inflater.inflate(R.layout.item_list_tracks, parent, false));
    }

    @Override
    public void onBindViewHolder(SoundViewHolder holder, int position) {
        holder.bindView(tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    class SoundViewHolder extends RecyclerView.ViewHolder {

        TextView track_name, track_genre;
        public SoundViewHolder(View itemView) {
            super(itemView);
            track_genre = itemView.findViewById(R.id.track_genre);
            track_name = itemView.findViewById(R.id.track_name);
        }

        void bindView(Sound sound) {
            track_name.setText(sound.getTitle());
            track_genre.setText(sound.getGenre());
        }
    }
}
