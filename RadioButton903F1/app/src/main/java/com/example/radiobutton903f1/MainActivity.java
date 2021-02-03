package com.example.radiobutton903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup rg; RadioButton rb;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=findViewById(R.id.fruitsList);
        tv=findViewById(R.id.textView2);
    }
    public  void check(View v){
        int radioID=rg.getCheckedRadioButtonId();
        rb=findViewById(radioID);
        Toast.makeText(getApplicationContext(),rb.getText().toString(),Toast.LENGTH_LONG).show();
        tv.setText(rb.getText().toString());
    }

}