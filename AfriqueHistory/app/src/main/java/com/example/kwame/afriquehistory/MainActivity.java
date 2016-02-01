package com.example.kwame.afriquehistory;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;
    private Context context;
    RequestQueue requestQueue;
    private ListView listView;
    private HistAfriqueAdapter adapter;
    private ProgressDialog pDialog;
    private List<HistAfrique> histAfriquesList = new ArrayList<HistAfrique>();
    private LruCache lruCache;

    private Float likes;
    private  String history;
    private JsonObjectRequest request;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    String url ="http://www.histafrique.com/api/v1/data/historical-places.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.afriqueListView);
//
        adapter = new HistAfriqueAdapter(this, histAfriquesList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("id", histAfriquesList.get(i).getId());
                startActivity(intent);
//                intent.putExtra();
            }
        });





//
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();


        //Creating volley response obj
        context = MainActivity.this;


//                               "source": "www.wikipedia.org",
//                               "country": "Ghana",
//                               "province": "Central Region",
//                               "relativeImageUrl": "/images/elmina1.jpg",
//                               "absoluteImageUrl": "http://s3.amazonaws.com/www.histafrique.com/images/elmina1.jpg",
//                               "owner": "dFJfzpuvZrpX7X65X",
//                               "latitude": "5.083000000000000000",
//                               "longitude": "-1.347999999999956300",
//                               "likes": 1

        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
              pDialog.hide();
                try{
                     jsonArray = response.getJSONArray("data");
//                    Toast.makeText(context, "RESPONSE "+jsonArray, Toast.LENGTH_LONG).show();
                   for(int i=0; i<jsonArray.length(); i++){

                       for(int j = 0; j<jsonArray.length(); j++){
                            jsonObject = jsonArray.getJSONObject(j);
                           HistAfrique items = new HistAfrique();
                           items.setPlaceName(jsonObject.getString("placeName"));
                           items.setSource(jsonObject.getString("source"));
                           items.setProvince(jsonObject.getString("province"));
                           items.setCountry(jsonObject.getString("country"));
                           items.setId(jsonObject.getString("_id"));


                           histAfriquesList.add(items);



                       }
                       adapter.notifyDataSetChanged();


                   }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidePDialog();
            }

        });

        AppController.getInstance().addToRequestQueue(request);

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
}
