package com.tony.android.fortnitestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fortniteBundles extends AppCompatActivity {

    ArrayList<FortniteBundle> itemslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortnite_bundles);

        ListView itemsListView = findViewById(R.id.fortniteListView);


// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://fortnite-public-api.theapinetwork.com/prod09/items/popular";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {

                            JSONObject responseJson = new JSONObject(response);
                            JSONArray data = responseJson.getJSONArray("data");
                            JSONObject hour = data.getJSONObject(0);
                            JSONArray entries = hour.getJSONArray("entries");
                            for (int i = 0; i < entries.length(); i++) {
                                JSONObject entry = entries.getJSONObject(i);
                                JSONObject images = entry.getJSONObject("images");


                                FortniteBundle item = new FortniteBundle(
                                        images.getString("info"),
                                        entry.getString("name"),
                                        entry.getString("description"),
                                        entry.getInt("cost"),
                                        entry.getString("rarity")
                                );

                                itemslist.add(item);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("PIZZA", error.toString());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
        ItemAdapter itemAdapter = new ItemAdapter(this, itemslist);
        itemsListView.setAdapter(itemAdapter);
    }
}
