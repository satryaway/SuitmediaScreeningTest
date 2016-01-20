package com.jixstreet.suitmediascreeningtest.models;

/**
 * Created by M Agung Satrio - agung.satrio@inmagine.com on 1/20/2016.
 */
public class Event {
    private String name, imageURL, date;

    public Event (String name, String imageURL, String date) {
        this.name = name;
        this.imageURL = imageURL;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
