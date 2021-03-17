package com.example.crudapp1903f1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etname,etage;
Button insert,view,del,upd;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.editTextTextPersonName);
        etage=findViewById(R.id.editTextTextPersonName2);
        insert=findViewById(R.id.button);
        view=findViewById(R.id.button2);
        del=findViewById(R.id.button3);
        upd=findViewById(R.id.button4);
        CreateTable();
        //insert data into tables
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL(" insert into Students values ('"+etname.getText().toString()+"','"+Integer.parseInt(etage.getText().toString())+"') ");
                Toast.makeText(MainActivity.this,"Record Inserted ",Toast.LENGTH_LONG).show();
            }
        });

        //view data from tables
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,GetAllUserActivity.class);
                startActivity(i);
            }
        });
        // delete data from tables
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete from Students  where name = name.getText().toString()
                db.execSQL(" delete from Students where name ='"+etname.getText().toString()+"'");
                Toast.makeText(MainActivity.this,"Record Deleted ",Toast.LENGTH_LONG).show();
            }
        });

        //update data from tables
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UPDATE Customers
                //SET ContactName='Alfred Schmidt', City='Frankfurt'
                //WHERE CustomerID=1;
                db.execSQL(" update Students set age ='"+etage.getText().toString()+"' where name ='"+etname.getText().toString() +"' ");
                Toast.makeText(MainActivity.this,"Record Updated ",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void CreateTable(){
        db =openOrCreateDatabase("StudentsDatabase",MODE_PRIVATE,null);
        db.execSQL(" create table if not exists Students (name text , age Integer)");
    }
}