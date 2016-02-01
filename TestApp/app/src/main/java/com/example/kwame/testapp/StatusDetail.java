package com.example.kwame.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class StatusDetail extends AppCompatActivity {

    String objectId;
    protected TextView objectIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_detail);

        objectIdTextView = (TextView) findViewById(R.id.objectIdTextView);

        Intent intent = getIntent();
        objectId = intent.getStringExtra("objectId");

        objectIdTextView.setText(objectId);

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Status");
        query.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null){
                    //success
                    String userStatus = parseObject.getString("newStatus");
                    objectIdTextView.setText(userStatus);
                } else {
                    //error advise user
                }
            }
        });
    }
}
