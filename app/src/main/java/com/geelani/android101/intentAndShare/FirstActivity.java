package com.geelani.android101.intentAndShare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geelani.android101.R;

public class FirstActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText detailEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initUI();
    }

    private void initUI() {
        //Initialize all views in this method
        nameEditText = findViewById(R.id.name);
        detailEditText = findViewById(R.id.detail);
        submitBtn = findViewById(R.id.submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nameEditText.getText().toString().contentEquals("") && !detailEditText.getText().toString().contentEquals("")) {
                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    intent.putExtra("name", nameEditText.getText().toString());
                    intent.putExtra("detail", detailEditText.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(FirstActivity.this, "Please enter value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
