package com.geelani.android101;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;


public class CarDetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    TextView nameTv;
    private SliderLayout mDemoSlider;
    private Button mapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
    }

    private void initUI() {
        nameTv = findViewById(R.id.name);
        mDemoSlider = findViewById(R.id.slider);
        nameTv.setText(getIntent().getStringExtra("name"));
        prepareImages();

        mapBtn = findViewById(R.id.launchMap);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarDetailActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void prepareImages() {
        ArrayList<String> images = new ArrayList<>();
        images.add("https://media.zigcdn.com/media/photogallery/2016/Nov/audi-a4-30tfsi-zigwheels-india-g37_640x480.jpg");
        images.add("https://media.zigcdn.com/media/photogallery/2016/Nov/audi-a4-30tfsi-zigwheels-india-g12_640x480.jpg");
        images.add("https://media.zigcdn.com/media/photogallery/2016/Nov/audi-a4-30tfsi-zigwheels-india-g09_640x480.jpg");
        images.add("https://media.zigcdn.com/media/photogallery/2016/Nov/audi-a4-30tfsi-zigwheels-india-g30_640x480.jpg");
        images.add("https://media.zigcdn.com/media/model/2016/Feb/audi_a42016_600x300.jpg");
        images.add("https://media.zigcdn.com/media/photogallery/2016/Nov/audi-a4-30tfsi-zigwheels-india-g04_640x480.jpg");

        //Slider documentation link
        //https://github.com/daimajia/AndroidImageSlider
        for(String image : images){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(image)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",image);

            mDemoSlider.addSlider(textSliderView);
        }
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
