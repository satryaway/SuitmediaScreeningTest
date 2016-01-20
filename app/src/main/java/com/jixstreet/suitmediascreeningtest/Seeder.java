package com.jixstreet.suitmediascreeningtest;

import com.jixstreet.suitmediascreeningtest.models.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M Agung Satrio - agung.satrio@inmagine.com on 1/20/2016.
 */
public class Seeder {

    public static List<Event> getEvents () {
        List<Event> eventList = new ArrayList<>();

        Event event;
        event = new Event("Food Expo 2016", "http://www.haievent.com/wp-content/uploads/2014/11/Pameran-Food-Bandung-Expo-2015.jpg", "11 January 2016");
        eventList.add(event);

        event = new Event("Play Day on Cafe", "http://jadwalevent.web.id/wp-content/uploads/2015/01/playdaycafe_januari15-res.jpg", "14 February 2016");
        eventList.add(event);

        event = new Event("Asian Cultural", "http://3.bp.blogspot.com/-Sp3xwQz_904/VdU9ibm68_I/AAAAAAAABMI/-esqERL1vjg/s1600/Event%2BJepang%2BTerbaru%2BDi%2BBandung%2BAsian%2BCultural%2BFor%2BMusic%2BDan%2BFashion%2BStyle%2BMiko%2BMall%2BAgustus%2BJapbandung-asia.blogspot.com.jpg", "30 June 2016");
        eventList.add(event);

        event = new Event("Pameran Bandung", "https://festivalindonesia.files.wordpress.com/2015/03/pameran-bandung-toys-kids-expo-2015.jpg", "16 March 2016");
        eventList.add(event);

        event = new Event("Kopo Wedding Celebration", "http://jadwalevent.web.id/wp-content/uploads/2015/02/Kopo-Wedding-Celebration-Bandung.jpg", "28 March 2016");
        eventList.add(event);

        return eventList;
    }
}
