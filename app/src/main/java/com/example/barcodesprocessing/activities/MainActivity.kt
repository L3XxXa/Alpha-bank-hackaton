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
        findViewById<Button>(R.id.button_scan).setOnClickListener {
            startActivity(Intent(this, BarcodeScannerActivity::class.java))
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(Intent(this, Generateqr::class.java))
        }

    }






}