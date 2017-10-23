package com.androidbootcamp.zoranmiladinovic.endava.locationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewTrackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_track);
    }

    public void onStartTrack(View view) {
        startActivity(new Intent(this, TrackDetailsActivity.class));
    }
}
