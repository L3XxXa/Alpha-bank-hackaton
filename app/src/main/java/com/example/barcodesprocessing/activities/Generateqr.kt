package com.example.barcodesprocessing.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.barcodesprocessing.barcodegenerator.model.Barcode
import com.example.namespace.R
import com.google.zxing.BarcodeFormat

import com.example.namespace.databinding.ActivityMainBinding


class Generateqr : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.button.setOnClickListener {
            showQr("21058302234357")
            showEan13()
        }
    }

    private fun showQr(value: String) {
        val barcode = Barcode(value, BarcodeFormat.QR_CODE)
        barcode.contentColor = ContextCompat.getColor(this, R.color.black)

        Glide.with(this)
            .load(barcode)
            .into(binding.firstQrView)
    }


    private fun showEan13() {
        val barcode = Barcode("978020137962", BarcodeFormat.EAN_13)
        barcode.contentColor = ContextCompat.getColor(this, R.color.black)

        Glide.with(this)
            .load(barcode)
            .into(binding.ean13View)
    }

}