package com.jixstreet.suitmediascreeningtest.models;

/**
 * Created by M Agung Satrio - agung.satrio@inmagine.com on 1/20/2016.
 */
public class Guest {
    private int id;
    private String name, birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
