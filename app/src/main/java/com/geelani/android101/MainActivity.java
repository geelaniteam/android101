package com.geelani.android101;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.geelani.android101.intentAndShare.FirstActivity;


public class MainActivity extends AppCompatActivity {

    private Button intentBtn;
    private Button listBtn;
    private Button list1Btn;
    private Button volleyBtn;
    private Button mapBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        intentBtn = findViewById(R.id.intent);
        listBtn = findViewById(R.id.listview);
        list1Btn = findViewById(R.id.listview1);
        volleyBtn = findViewById(R.id.volley);
        mapBtn = findViewById(R.id.map);


        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);

            }
        });


        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);

            }
        });

        list1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewCustomAdapterActivity.class);
                startActivity(intent);

            }
        });


        volleyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewVolleyActivity.class);
                startActivity(intent);

            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);

            }
        });
    }
}
