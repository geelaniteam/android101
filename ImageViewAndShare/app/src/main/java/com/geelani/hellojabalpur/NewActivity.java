package com.geelani.hellojabalpur;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class NewActivity extends AppCompatActivity {

    final int PERMISSION_CALLBACK_CONSTANT = 101;
    TextView nameTv;
    TextView detailTv;
    ImageView imageView;
    Button shareBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initUI();
    }

    private void initUI() {
        //Initialize all views in this method
        nameTv = findViewById(R.id.name);
        imageView = findViewById(R.id.image);
        detailTv = findViewById(R.id.detail);
        shareBtn = findViewById(R.id.share);
        nameTv.setText(getIntent().getStringExtra("name"));
        detailTv.setText(getIntent().getStringExtra("detail"));
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
//                String shareBody = "Hi, We have shared text";
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//                startActivity(Intent.createChooser(sharingIntent, "Share"));

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

                Uri bmpUri = null;
                if (ActivityCompat.checkSelfPermission(NewActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    //just request the permission
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_CALLBACK_CONSTANT);
                    Toast.makeText(NewActivity.this, "Allow Permissions from app settings", Toast.LENGTH_LONG).show();

                } else {
                    //You already have the permission, just go ahead.
                    bmpUri = getLocalBitmapUri(imageView);
                    String shareBody = " We have shared image ";//offer title
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("image/*");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    sharingIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }

            }
        });
    }

    public static Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable) {
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
            file.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }
}
