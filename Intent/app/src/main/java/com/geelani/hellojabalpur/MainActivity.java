package com.geelani.hellojabalpur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText detailEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                //crash
//                if (TextUtils.isEmpty(nameEditText.getText().toString()) && TextUtils.isEmpty(detailEditText.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this,NewActivity.class);
                    intent.putExtra("name", nameEditText.getText().toString());
                    intent.putExtra("detail", detailEditText.getText().toString());
                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "Please enter value", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}
