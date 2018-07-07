package com.geelani.day1_p5_imageviewpicasso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class NewActivity extends AppCompatActivity {

    TextView nameTv;
    TextView detailTv;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initUI();
    }

    private void initUI() {
        //Initialize all views in this method
        nameTv = findViewById(R.id.name);
        detailTv = findViewById(R.id.detail);
        nameTv.setText(getIntent().getStringExtra("name"));
        detailTv.setText(getIntent().getStringExtra("detail"));

        imageView = findViewById(R.id.image);
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }
}
