package com.androidbootcamp.zoranmiladinovic.endava.locationtracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
    }
}
