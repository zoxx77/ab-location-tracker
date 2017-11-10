package com.androidbootcamp.zoranmiladinovic.endava.locationtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidbootcamp.zoranmiladinovic.endava.locationtracker.model.Location;

public class SettingsActivity extends Activity {

    public static final String SETTINGS_PREFERENCES_FILE = "SETTINGS";
    public static final String CITY_INDEX_PREFERENCES_KEY = "CITY_INDEX";
    public static final int DEFAULT_CITY_INDEX = 0;
    private static final String SAMPLING_RATE = "SAMPLING_RATE";

    private EditText editTextSettingsSamplingRate;
    private EditText editTextSettingsSpeed;
    private Spinner spinnerSettingsCities;
    private TextView textViewSettingsLatitude;
    private TextView textViewSettingsLongitude;
    private TextView textViewSettingsAltitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        editTextSettingsSamplingRate = findViewById(R.id.editTextSettingsSamplingRate);
        editTextSettingsSpeed = findViewById(R.id.editTextSettingsSpeed);
        spinnerSettingsCities = findViewById(R.id.spinnerSettingsCities);
        textViewSettingsLatitude = findViewById(R.id.textViewSettingsLatitude);
        textViewSettingsLongitude = findViewById(R.id.textViewSettingsLongitude);
        textViewSettingsAltitude = findViewById(R.id.textViewSettingsAltitude);

        spinnerSettingsCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String latitude = getResources().getStringArray(R.array.homeCitiesLatitudes)[i];
                String longitude = getResources().getStringArray(R.array.homeCitiesLongitudes)[i];
                String altitude = getResources().getStringArray(R.array.homeCitiesAltitudes)[i];

                textViewSettingsLatitude.setText(getString(R.string.settings_latitude_format, latitude));
                textViewSettingsLongitude.setText(getString(R.string.settings_latitude_format, longitude));
                textViewSettingsAltitude.setText(getString(R.string.settings_altitude_format, altitude));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SharedPreferences settingsSharedPreferences = getSharedPreferences(SettingsActivity.SETTINGS_PREFERENCES_FILE, Context.MODE_PRIVATE);

        editTextSettingsSamplingRate.setText(settingsSharedPreferences.getString(SAMPLING_RATE, "0"));
        editTextSettingsSpeed.setText(settingsSharedPreferences.getString(Location.SPEED_KEY, "0"));
        spinnerSettingsCities.setSelection(settingsSharedPreferences.getInt(CITY_INDEX_PREFERENCES_KEY, DEFAULT_CITY_INDEX));
    }

    public void onDone(View view) {
       Boolean errorDetected = validateInput(view);

        if (errorDetected) {
            // Notify user that there are an errors with his/hers entries.
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.settings_dialog_title))
                    .setMessage(getString(R.string.settings_dialog_message))
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.settings_dialog_ok),
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }
    }

    private Boolean validateInput(View view) {
        boolean errorDetected = false;
        if (editTextSettingsSamplingRate.getText().toString().equalsIgnoreCase("")) {
            editTextSettingsSamplingRate.setError(
                    getString(R.string.settings_error_field_format,
                            getString(R.string.settings_field_sampling_rate)));
            errorDetected = true;
        }

        if (editTextSettingsSpeed.getText().toString().equalsIgnoreCase("")) {
            editTextSettingsSpeed.setError(
                    getString(R.string.settings_error_field_format,
                            getString(R.string.settings_field_speed)));
            errorDetected = true;
        }

        return errorDetected;
    }
}
