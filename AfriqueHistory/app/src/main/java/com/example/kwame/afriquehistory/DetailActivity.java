package com.example.kwame.afriquehistory;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {
    private ProgressDialog pDialog;
    TextView textView;
    ImageView imageView;
    String url ="http://www.histafrique.com/api/v1/historical-places/";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = (TextView) findViewById(R.id.history);
        imageView = (ImageView) findViewById(R.id.detailImageView);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();


        String id = getIntent().getStringExtra("id");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+id, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
//                Toast.makeText(getApplicationContext(), "RESPONSE "+ response.toString(), Toast.LENGTH_LONG).show();
                pDialog.hide();
                try{
                 JSONObject jsonObject = response.getJSONObject("data");
//                    Toast.makeText(context, "RESPONSE "+jsonArray, Toast.LENGTH_LONG).show();
                        textView.setText(jsonObject.getString("history"));


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
                hidePDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
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
