package com.geelani.day_02_p4_listviewclick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;



public class CarDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
    }

    private void initUI() {

        imageView = findViewById(R.id.imageView);
        nameTv = findViewById(R.id.name);
        imageView.setImageResource(getIntent().getIntExtra("image",R.mipmap.ic_launcher));
        nameTv.setText(getIntent().getStringExtra("name"));
    }
}
