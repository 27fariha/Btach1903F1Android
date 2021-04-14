package com.example.firstkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun calculate(v:View){
var age=findViewById<EditText>(R.id.editTextTextPersonName)
var res=findViewById<TextView>(R.id.textView2)
        val current_year=Calendar.getInstance().get(Calendar.YEAR)
     res.text="Age :"+(current_year-age.text.toString().toInt())
    }
}