package com.example.firstkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener(){
            Toast.makeText(this,"This is First Message",Toast.LENGTH_LONG).show();
        }

        var btnNext=findViewById<Button>(R.id.button1)
        btnNext.setOnClickListener(){
            var i =Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
    }
}