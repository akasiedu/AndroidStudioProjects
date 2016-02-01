package com.akasiedu.maplocation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MapLocation extends ActionBarActivity {
    private final String TAG = "MapLocation";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_location);

        final EditText addrText = (EditText) findViewById(R.id.location);
        final Button button = (Button) findViewById(R.id.mapButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String address = addrText.getText().toString();
                    address = address.replace(' ', '+');


                    Intent geoIntent = new Intent(
                            android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address)
                    );
                    startActivity(geoIntent);
                } catch (Exception e){
                    Log.e(TAG, e.toString());
                }
            }
        });
    }
}
