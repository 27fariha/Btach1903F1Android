package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
GridView gv;
int logo[]={R.drawable.img1,R.drawable.img2,R.drawable.burgershop,R.drawable.icon ,R.drawable.php};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.grid);
        customAdapter c= new customAdapter(MainActivity.this,logo);
        gv.setAdapter(c);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("image", logo[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
    }
}
