package com.example.customlist1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView lv;
     int[] img={R.drawable.cc,R.drawable.java,R.drawable.php,R.drawable.python};
           // 0             1                   2           3
     String[] imgtitle={"C#","JAVA","PHP","PYTHON"};
    String[] imgdes={"C# is a general-purpose, multi-paradigm programming language","Java is a class-based, object-oriented programming language"
            ,"PHP is a general-purpose scripting language","Python is an interpreted, high-level and general-purpose programming language"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.mylist);
        customAdapter adp=new customAdapter(MainActivity.this,img,imgtitle,imgdes);
        lv.setAdapter(adp);
    }
}
