package com.example.kwame.testapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class MainActivity extends ListActivity {

protected List<ParseObject> mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            ParseQuery<ParseObject> parseQuery = new ParseQuery<ParseObject>("Status");
            parseQuery.orderByDescending("createdAt");
            parseQuery.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> status, ParseException e) {
                    if (e == null){
                        //success
                        mStatus = status;
                        StatusAdapter adapter = new StatusAdapter(getListView().getContext(), mStatus);
                        setListAdapter(adapter);
                    }else{
                        //there was a problem, alert user
                    }
                }
            });
        } else {
            // show the signup or login screen
            Intent intent = new Intent(this, LoginActivty.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.createItem:
                Intent intent = new Intent(MainActivity.this, CreateStatus.class);
                startActivity(intent);
                break;
            case R.id.logOut:
                ParseUser.logOut();
                Intent backtologInScreen = new Intent(this, LoginActivty.class);
                startActivity(backtologInScreen);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        ParseObject statusObject = mStatus.get(position);
        String objectId = statusObject.getObjectId();

        Intent goToDetail = new Intent(MainActivity.this, StatusDetail.class);
        goToDetail.putExtra("objectId", objectId);
        startActivity(goToDetail);
    }
}
