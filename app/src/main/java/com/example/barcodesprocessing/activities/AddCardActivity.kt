package com.example.barcodesprocessing.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.barcodesprocessing.barcodeanalyzer.ReceiveCode
import com.example.namespace.databinding.ActivityAddCardBinding

class AddCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scanCard.setOnClickListener() {
            ReceiveCode.setCode(null)
            startActivity(Intent(this, BarcodeScannerActivity::class.java))
        }

        binding.addCard.setOnClickListener() {
            val text = binding.cardName.text.toString()
            Log.d("AddCard", text)
            ReceiveCode.setName(text)
//            startActivity(Intent(this, Generateqr::class.java))
        }

    }
}