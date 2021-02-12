package com.example.datasend1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DashBoradActivity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_borad);
        t1=findViewById(R.id.textView2);
        Intent a=getIntent();
        String name =a.getStringExtra("sendName");
        t1.setText(name.toString());
    }
}