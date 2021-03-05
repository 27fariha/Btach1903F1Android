package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main2Activity extends AppCompatActivity {
    ImageView selectedImage;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=(Button)findViewById(R.id.button);
        selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        Intent intent = getIntent(); // get Intent which we set from Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0));
//save image work



        ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        File sdcard = Environment.getExternalStorageDirectory();
        final File directory = new File(sdcard.getAbsolutePath() + "/MultipleImages");
        directory.mkdir();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable drawable = (BitmapDrawable)selectedImage.getDrawable();
                Bitmap bit = drawable.getBitmap();



                String filename = String.format("%d.png", System.currentTimeMillis());
                File outfile = new File(directory,filename);

                Toast.makeText(Main2Activity.this, "Image Saved!", Toast.LENGTH_SHORT).show();


                try {
                    FileOutputStream outputstream = new FileOutputStream(outfile);
                    bit.compress(Bitmap.CompressFormat.PNG, 100, outputstream);
                    outputstream.flush();
                    outputstream.close();

                    Intent i = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                    i.setData(Uri.fromFile(outfile));
                    sendBroadcast(i);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
