package com.androidbootcamp.zoranmiladinovic.endava.locationtracker.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.androidbootcamp.zoranmiladinovic.endava.locationtracker.R;
import com.androidbootcamp.zoranmiladinovic.endava.locationtracker.model.Location;

import java.util.List;

/**
 * Created by Zoran.Miladinovic on 11/2/2017.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    Context context;

    public LocationAdapter(List<Location> data, Context context) {
        super(context, R.layout.activity_add_location, data);
        this.context = context;
    }

}
