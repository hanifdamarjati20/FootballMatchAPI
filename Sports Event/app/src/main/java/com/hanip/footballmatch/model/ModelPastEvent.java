package com.hanip.footballmatch.model;

import android.view.View;

import java.io.Serializable;

import io.realm.RealmObject;

public class ModelPastEvent extends RealmObject implements Serializable {

    private int IdEvent;
    private String Event;
    //private double VoteAverage;
    private String FileName;
    private String Venue;
    private String Thumb;
    //private String BackdropPath;
    private String Country;

    public ModelPastEvent() { }

    public int getIdEvent() {
        return IdEvent;
    }

    public void setIdEvent(int idEvent) {
        IdEvent = idEvent;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) { Event = event; }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) { FileName = fileName; }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) { Venue = venue; }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String thumb) { Thumb = thumb; }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) { Country = country; }
}