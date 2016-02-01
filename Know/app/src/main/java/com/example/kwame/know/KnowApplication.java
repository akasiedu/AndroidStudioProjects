package com.example.kwame.know;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by kwame on 12/7/15.
 */
public class KnowApplication extends Application {
    private String APPLICATION_ID = "xPtLs30jMC7onvmqm0qc6PkqmUlvfUxRhYo26sN4";
    private String CLIENT_KEY = "EuCUkmVKygajcbdcNbgR2jRDLTomuKdFIqOH5oMS";


    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
    }
}
