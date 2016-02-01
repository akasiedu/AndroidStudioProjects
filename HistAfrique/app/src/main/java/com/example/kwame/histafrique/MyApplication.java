package com.example.kwame.histafrique;

import android.app.Application;
import android.content.Context;

/**
 * Created by kwame on 10/8/15.
 */
public class MyApplication extends Application{
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }

    public static MyApplication getsInstance(){
        return sInstance;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }

}
