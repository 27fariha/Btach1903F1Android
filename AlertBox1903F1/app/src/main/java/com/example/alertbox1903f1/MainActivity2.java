package com.example.alertbox1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
ImageView img;
Button btn;
private int current_img_index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img=findViewById(R.id.imageView);
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] images={R.mipmap.ic_img1,R.mipmap.ic_img2,R.mipmap.ic_img3,R.mipmap.ic_img4};
                current_img_index++;
                current_img_index=current_img_index % images.length;
                img.setImageResource(images[current_img_index]);
            }
        });
    }
}