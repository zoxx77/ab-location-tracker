package com.androidbootcamp.zoranmiladinovic.endava.locationtracker.model;

/**
 * Created by Zoran.Miladinovic on 10/31/2017.
 */

public class Location {

    public static final String TRACK_ID = "track_id";
    public static final String LATITUDE_KEY = "latitude";
    public static final String LONGITUDE_KEY = "longitude";
    public static final String ALTITUDE_KEY = "altitude";
    public static final String SPEED_KEY = "speed";

    public static final int MIN_LATITUDE = -90;
    public static final int MAX_LATITUDE = 90;
    public static final int MIN_LONGITUDE = -180;
    public static final int MAX_LONGITUDE = 180;

    private long id;
    private long trackId;
    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;

    public Location(long trackId, double latitude, double longitude, double altitude, double speed) {
        this.trackId = trackId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public long getTrackId() {
        return trackId;
    }

    public double getSpeed() {
        return speed;
    }
}
