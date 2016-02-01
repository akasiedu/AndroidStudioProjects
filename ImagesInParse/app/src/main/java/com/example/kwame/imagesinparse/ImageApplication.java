package com.example.kwame.imagesinparse;


import android.app.Application;

import com.parse.Parse;

/**
 * Created by kwame on 12/1/15.
 */
public class ImageApplication extends Application {
    private String APPLICATION_ID = "j5QbqwZnZJX6nCQ20idzFS6INF3rhcrT1NwZUjSR";
    private String CLIENT_KEY = "kjuW21IY8Prj52eVI0AK7mY1uBR14pz1IMsmL9f8";


    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

    }
}
