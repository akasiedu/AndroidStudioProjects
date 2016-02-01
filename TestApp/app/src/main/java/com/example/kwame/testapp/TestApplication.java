package com.example.kwame.testapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by kwame on 11/14/15.
 */
public class TestApplication extends Application {

    private String APPLICATION_ID = "KfM87tVT9R0Em3tzmfpzO2TeNFDRWaE3N1AL0i2v";
    private String CLIENT_KEY = "QSGfg29juTJxpLVPwi3CRFxuOTkkGS19FvGY8agW";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

//        ParseObject parseObject = new ParseObject("hey");
//        parseObject.put("Kwame", "Asiedu");
//        parseObject.saveInBackground();
    }

}
