package com.geelani.day_03_p1_launchmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class CarDetailActivity extends AppCompatActivity  {

    Button mapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
    }

    private void initUI() {
    mapBtn = findViewById(R.id.launchMap);
    mapBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CarDetailActivity.this,MapActivity.class);
            startActivity(intent);
        }
    });
    }





}
