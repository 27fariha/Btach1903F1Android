package com.example.sqlitedemo1903f1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Currency;

public class MainActivity extends AppCompatActivity {
DatabaseHelper mydb;
EditText name,age;
Button insert,get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new DatabaseHelper(this);
        name=findViewById(R.id.editTextTextPersonName);
        age=findViewById(R.id.editTextTextPersonName2);
        insert=findViewById(R.id.button);
        get=findViewById(R.id.button2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean a = mydb.InsertRecord(name.getText().toString(),Integer.parseInt(age.getText().toString()));
                if(a==true){
                    Toast.makeText(MainActivity.this,"Insert Record",Toast.LENGTH_LONG).show();
                    name.setText("");
                    age.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this,"Record Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
        Show();
    }

    public  void Show(){
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor c= mydb.GetAll();
               if(c.getCount() == 0){
                   Toast.makeText(MainActivity.this,"No Record Found",Toast.LENGTH_LONG).show();
               }
               StringBuffer b=new StringBuffer();
               while (c.moveToNext()){
                   b.append("Name "+c.getString(0)+"\n");
                   b.append("Age "+c.getString(1)+"\n");
               }
           ShowData("Record",b.toString());
            }
        });
    }

    public void ShowData(String title,String msg){
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
        b.setTitle(title)
                .setMessage(msg)
                .setCancelable(true)
                .show();
    }

}