package com.example.fragment1903f1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void change(View v){
        if( v == findViewById(R.id.button)){
            FragmentOne frag=new FragmentOne();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.frag_place,frag);
            ft.commit();
        }
        if(v == findViewById(R.id.button2)){
            FragmentTwo frag=new FragmentTwo();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.frag_place,frag);
            ft.commit();
        }
    }
}