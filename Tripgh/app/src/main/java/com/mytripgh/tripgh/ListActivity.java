package com.mytripgh.tripgh;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by eit on 4/24/15.
 */
public class ListActivity extends ActionBarActivity {
    Button tourNow;
    String myitems[]={
            "Greater Accra",
            "Central Region",
            "Eastern Region",
            "Brong Ahafo Region",
            "Ashanti Region",
            "Western Region",
            "Volta Region",
            "Upper East Region",
            "Upper West Region",
            "Northen Region"};
    ListView listitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        tourNow = (Button)findViewById(R.id.tourNow);
        listitems = (ListView)findViewById(R.id.list_view);

        ArrayAdapter<String> myarrayadapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, myitems);
        listitems.setAdapter(myarrayadapter);
    }
}
