package com.androidbootcamp.zoranmiladinovic.endava.locationtracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zoran.Miladinovic on 10/31/2017.
 */

public class Track {
    public static final String TRACK_ID = "id";
    public static final String TRACK_NAME = "name";
    public static final String TRACK_DESCRIPTION = "description";

    private long id;
    private String name;
    private String description;
    private List<Location> locations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
