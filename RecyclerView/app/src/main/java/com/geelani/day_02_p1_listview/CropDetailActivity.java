package com.geelani.day_02_p1_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CropDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameTv;
    TextView descTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
    }

    private void initUI() {

        imageView = findViewById(R.id.imageView);
        nameTv = findViewById(R.id.name);
        descTv = findViewById(R.id.desc);
        nameTv.setText(getIntent().getStringExtra("name"));
        descTv.setText(getIntent().getStringExtra("desc"));
       String imageUrl = getIntent().getStringExtra("imageUrl");
        Picasso.get().load(imageUrl).into(imageView);
    }
}
