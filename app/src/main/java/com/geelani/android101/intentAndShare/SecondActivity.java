package com.geelani.android101.intentAndShare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geelani.android101.R;


public class SecondActivity extends AppCompatActivity {

    TextView nameTv;
    TextView detailTv;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initUI();
    }

    private void initUI() {
        //Initialize all views in this method
        nameTv = findViewById(R.id.name);
        detailTv = findViewById(R.id.detail);
        shareBtn = findViewById(R.id.share);
        nameTv.setText(getIntent().getStringExtra("name"));
        detailTv.setText(getIntent().getStringExtra("detail"));
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareBody = "Hi, We have shared text";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share"));
//
//
//                //To share text only over SMS

//                String smsBody="Hi, We have shared text";
//                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                sendIntent.putExtra("sms_body", smsBody);
//                sendIntent.setType("vnd.android-dir/mms-sms");
//                startActivity(sendIntent);


                //To set email sbuject and body and email address here and open email app

//                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                        "mailto","abc@mail.com", null));
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, "address");
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi,We have shared Text");
//                startActivity(Intent.createChooser(emailIntent, "Send Email..."));


                //To pass image to other apps.
                //To pass an image we need permission for Android M and above android versions.



            }
        });
    }
}
