package com.androidbootcamp.zoranmiladinovic.endava.locationtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class NewTrackActivity extends Activity {

    EditText editTextName;
    EditText editTextDescription;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_track);

        editTextName = findViewById(R.id.editTextSettingsSamplingRate);
        editTextDescription = findViewById(R.id.editTextNewTrackDescription);
        progressBar = findViewById(R.id.progressBarNewTrack);
    }

    public void onStartTrack(View view) {
        Boolean errorDetected = false;

        String strEditTextName = editTextName.getText().toString();
        String strEditTextDescription = editTextDescription.getText().toString();

        if (strEditTextName.equalsIgnoreCase("")) {
            editTextName.setError(getString(R.string.new_track_error_field_format, getString(R.string.new_track_field_name).toLowerCase()));
            errorDetected = true;
        }

        if (strEditTextDescription.equalsIgnoreCase("")) {
            editTextDescription.setError(getString(R.string.new_track_error_field_format, getString(R.string.new_track_field_description).toLowerCase()));
            errorDetected = true;
        }

        if (errorDetected) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.new_track_dialog_title))
                    .setMessage(getString(R.string.new_track_dialog_message))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.new_track_dialog_ok),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }

        showProgressBar();

        // startActivity(new Intent(this, TrackDetailsActivity.class));
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}
