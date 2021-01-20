package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     int a,b;
     EditText et1,et2;
     Button add,sub,div,mul;
     TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editTextNum1);
        et2=findViewById(R.id.editTextNum2);
        add=findViewById(R.id.btnadd);
        sub=findViewById(R.id.btnsub);
        div=findViewById(R.id.btndiv);
        mul=findViewById(R.id.btnmul);
        res=(TextView)findViewById(R.id.res);


    }
    public void Add(View v){
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());
        int c=a+b;
        res.setText(Integer.toString(c));
        et1.setText("");
        et2.setText("");
    }
    public void Sub(View v){
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());
        int c=a-b;
        res.setText(Integer.toString(c));
        et1.setText("");
        et2.setText("");
    }
    public void Div(View v){
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());
        int c=a/b;
        res.setText(Integer.toString(c));
        et1.setText("");
        et2.setText("");
    }
    public void Mul(View v){
        a=Integer.parseInt(et1.getText().toString());
        b=Integer.parseInt(et2.getText().toString());
        int c=a*b;
        res.setText(Integer.toString(c));
        et1.setText("");
        et2.setText("");
    }
}