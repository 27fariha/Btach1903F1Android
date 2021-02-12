package com.example.datasend1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etname;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.editTextTextPersonName);
        login =findViewById(R.id.button);
    }
    public void CheckUser(View v){
        String name=etname.getText().toString();
        if(name.equals("")){
            Toast.makeText(getApplicationContext(),"Enter Name First",Toast.LENGTH_LONG).show();
        }
        else{
            Intent i=new Intent(MainActivity.this,DashBoradActivity.class);
            i.putExtra("sendName",name);
            startActivity(i);
        }


    }
}