package com.pratap.ninja.soundcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pratap.ninja.soundcheck.adapters.SoundAdapter;
import com.pratap.ninja.soundcheck.api.SoundService;
import com.pratap.ninja.soundcheck.models.Sound;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    public static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_tracks);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        final SoundAdapter adapter = new SoundAdapter(this);
        rv.setAdapter(adapter);

        SoundService.getSoundApi().getTracks().enqueue(new Callback<ArrayList<Sound>>() {
            @Override
            public void onResponse(Call<ArrayList<Sound>> call, Response<ArrayList<Sound>> response) {
                Log.d(TAG,"here =====> " + response.body());
                adapter.updateTracks(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Sound>> call, Throwable t) {

            }
        });

    }
}
