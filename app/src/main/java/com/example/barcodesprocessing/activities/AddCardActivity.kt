package com.example.barcodesprocessing.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
            if (ReceiveCode.getCode() != null){
            ReceiveCode.setName(text)
            Toast.makeText(this, "Карта добавлена", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            }
            else if (text == ""){
                Toast.makeText(this, "Введите название карты", Toast.LENGTH_SHORT).show()
            }
            else if (ReceiveCode.getCode() == null){
                Toast.makeText(this, "Отсканируйте карту", Toast.LENGTH_SHORT).show()
            }
        }

    }
}