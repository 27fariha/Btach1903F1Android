package com.example.sqlitedemo1903f1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database="Students.db";
    public static final String Table_Name ="Student_Record";

    public DatabaseHelper(Context context) {
        super(context, Database, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL(" create table "+Table_Name+"(name text , age Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL(" drop table if exists "+Table_Name);
    }

    public boolean InsertRecord(String Pname,int Page){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contVal =new ContentValues();
        contVal.put("name",Pname);
        contVal.put("age",Page);
        long res=db.insert(Table_Name,null,contVal);
        if(res == -1){ return  false;}
        else{ return true;}
    }

    public Cursor GetAll(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from "+Table_Name,null);
        return  c;
    }

}
