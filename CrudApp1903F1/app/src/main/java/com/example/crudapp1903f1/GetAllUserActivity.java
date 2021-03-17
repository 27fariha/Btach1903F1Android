package com.example.crudapp1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GetAllUserActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ArrayList<String> list;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_user);
        CreateTable();
        lv=findViewById(R.id.mylist);
        String query="select * from Students";
        Cursor c;
        c=db.rawQuery(query,null);
        list=new ArrayList<>();
        while (c.moveToNext()){
            String name=c.getString(0);
            int age=Integer.parseInt(c.getString(1));
            list.add("Name : "+name+"\n"+"Age :"+age+"\n");

        }
        ArrayAdapter<String> adp=new ArrayAdapter<String>(GetAllUserActivity.this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adp);
    }
    public void CreateTable(){
        db =openOrCreateDatabase("StudentsDatabase",MODE_PRIVATE,null);
        db.execSQL(" create table if not exists Students (name text , age Integer)");
    }
}