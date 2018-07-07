package com.geelani.broadcastreciever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_msg = findViewById(R.id.edit_msg);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edit_msg.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter a message to broadcast", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent("com.geelani.MY_ACTION");
                    intent.putExtra("data", edit_msg.getText().toString());
                    sendBroadcast(intent);
                }
            }
        });

    }
}
