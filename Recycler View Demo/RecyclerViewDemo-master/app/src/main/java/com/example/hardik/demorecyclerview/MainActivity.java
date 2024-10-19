package com.example.hardik.demorecyclerview;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<MainItem> nameList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainBaseAdepter mAdapter;

    String JsonURL = "https://demo1-dc826.firebaseio.com/.json";

    RequestQueue requestQueue;

    String data1 = "";
    String data2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mAdapter = new MainBaseAdepter(nameList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MainItem name = nameList.get(position);
                Toast.makeText(getApplicationContext(), " Click Thia Name : " + name.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Long click on: " + position, Toast.LENGTH_SHORT).show();
            }
        }));

        dataload();
    }

    public void dataload123() {

        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, JsonURL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("data");
                    nameList.clear();
                    for (int i = 0; i < data.length(); i++) {
                        MainItem mainItem = new MainItem();
                        mainItem.setName(data.getString(i));
                        nameList.add(mainItem);
                    }
//                    Log.d("#data", nameList.toString() + " length: " + nameList.size());
                    mAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(objectRequest);

    }

    public void dataload() {

        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, JsonURL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray data = response.getJSONArray("demo");
                    nameList.clear();
                    for (int i = 0; i < data.length(); i++) {

                        JSONObject obj1 = data.getJSONObject(i);

//                        JSONObject obj = response.getJSONObject("");
                        String name = obj1.getString("name");
                        String number = obj1.getString("number");

                        MainItem mainItem = new MainItem();
//                        mainItem.setName(data.getString(i));
                        mainItem.setName(name);
                        mainItem.setNumber(number);
                        nameList.add(mainItem);

                    }

//                    Log.d("#data", nameList.toString() + " length: " + nameList.size());
                    mAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) /*{
            // method user
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("task", "fetchuser");
                params.put("page", "1");
                return params;
            }


        }*/;
        requestQueue.add(objectRequest);
    }

}
