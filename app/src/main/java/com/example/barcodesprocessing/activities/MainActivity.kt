package com.example.barcodesprocessing.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.namespace.R

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chose)

        //button to start barcode scanner activity
        findViewById<Button>(R.id.button_add).setOnClickListener {
            startActivity(Intent(this, AddCardActivity::class.java))
        }

        findViewById<Button>(R.id.button_show).setOnClickListener {
            startActivity(Intent(this, GenerateqrActivity::class.java))
        }

    }






}