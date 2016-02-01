package com.example.kwame.histafrique;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  Context context;
    VolleySingleton volleySingleton;
    RequestQueue requestQueue;
    private ListView listView;
    private HistAfriqueAdapter adapter;
    private ProgressDialog pDialog;
    private List<HistAfrique> histAfriques = new ArrayList<HistAfrique>();
    String url ="http://www.histafrique.com/api/v1/data/historical-places.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = MainActivity.this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d("HeLLO", "Hello");
        listView = (ListView) findViewById(R.id.afriqueListView);
        adapter = new HistAfriqueAdapter(this,histAfriques);
        listView.setAdapter(adapter);


        // Instantiate the RequestQueue.
        volleySingleton=VolleySingleton.getsInstance();
        requestQueue=volleySingleton.getRequestQueue();


        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue requestQueue = VolleySingleton.getsInstance().getRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Toast.makeText(context, "RESPONSE "+ response, Toast.LENGTH_LONG).show();
                if (response==null || response.length() == 0){
                    Toast.makeText(context, "Network Connection Error", Toast.LENGTH_LONG).show();
                    return;
                }else {
//                    pDialog.hide();
                    try {
                        JSONArray jsonArray=response.getJSONArray("data");

                        for (int i=0; i<10;i++){
                            JSONObject jsonObject=jsonArray.getJSONObject(i);
                            HistAfrique item = new HistAfrique();
                            item.setPlaceName(jsonObject.getString("placeName"));
                            item.setCountry(jsonObject.getString("country"));
                            item.setProvince(jsonObject.getString("province"));
//                            item.setLikes(jsonObject.getString("likes"));

                            histAfriques.add(item);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
