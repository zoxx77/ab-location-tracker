package com.androidbootcamp.zoranmiladinovic.endava.locationtracker;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MyTracksActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tracks);
    }

    public void onClick(View view) {
        startActivity(new Intent(this, NewTrackActivity.class));
    }
}
