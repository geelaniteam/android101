package com.geelani.hellojabalpur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class NewActivity extends AppCompatActivity {

    TextView nameTv;
    TextView detailTv;
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
        String name = getIntent().getStringExtra("name");
        Log.d("name",name);
        nameTv.setText(name);
        String detail = getIntent().getStringExtra("detail");
        Log.d("detail",detail);
        detailTv.setText(detail);
    }

}
