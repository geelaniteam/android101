package com.geelani.day_02_p1_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Crop> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromRaw());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String desc = jsonObject.getString("desc");
                String imageUrl = jsonObject.getString("imageUrl");
                Crop crop = new Crop();
                crop.setName(name);
                crop.setDesc(desc);
                crop.setImage(imageUrl);
                //Add your values in your `ArrayList` as below:
                data.add(crop);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  Get a reference to the recyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //set layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // parseData from raw file
        //  Create an adapter
        AdapterCorps adapterCorps = new AdapterCorps(this, recyclerView, data);
        // Set the adapter
        recyclerView.setAdapter(adapterCorps);
    }



    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(
                    getResources().getIdentifier("crops",
                            "raw", getPackageName()));
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

