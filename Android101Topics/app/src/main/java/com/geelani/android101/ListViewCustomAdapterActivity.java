package com.geelani.android101;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.geelani.android101.adapters.CarsAdapter;
import com.geelani.android101.models.Car;

import java.util.ArrayList;
import java.util.List;

public class ListViewCustomAdapterActivity extends AppCompatActivity {

    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //  Get a reference to the listview
        ListView mListView = findViewById(R.id.listview);
        //  Create an adapter
        final CarsAdapter carsAdapter = new CarsAdapter(this, setCars());
        // Set the adapter
        mListView.setAdapter(carsAdapter);
    }


    private List<Car> setCars() {
        data = new ArrayList<>();
        data.add("Audi A4");
        data.add("BMW X1");
        data.add("Volvo X60");
        data.add("Toyota Innova");
        data.add("Maruti Swift");
        data.add("Hyundai i20");

        int[] iconID = {
                R.drawable.audi_a4,
                R.drawable.bmw_x1,
                R.drawable.volvo_x60,
                R.drawable.toyota_innova,
                R.drawable.maruti_swift,
                R.drawable.hyundai_i20,
        };

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            cars.add(new Car(data.get(i), iconID[i]));
        }

        return cars;
    }
}

