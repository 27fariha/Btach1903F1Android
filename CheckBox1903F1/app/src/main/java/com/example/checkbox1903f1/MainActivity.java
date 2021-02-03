package com.example.checkbox1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1,b2,b3,b4;
TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.en1);
        e2=findViewById(R.id.en2);
        b1=findViewById(R.id.add);
        b2=findViewById(R.id.multi);
        b3=findViewById(R.id.sub);
        b4=findViewById(R.id.divide);
        t1=findViewById(R.id.msg);

    }

    public void calculator (View v){
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
    }

}