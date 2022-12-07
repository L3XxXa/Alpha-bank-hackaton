package com.example.barcodesprocessing.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.barcodesprocessing.barcodeanalyzer.ReceiveCode
import com.example.barcodesprocessing.barcodegenerator.model.Barcode
import com.example.namespace.R
import com.example.namespace.databinding.ActivityMainBinding
import com.google.zxing.BarcodeFormat


class Generateqr : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var codeVal = ReceiveCode.getCode()
        setContentView(binding.root)
        val textView = findViewById<TextView>(R.id.qrValue)
        val imageView = findViewById<TextView>(R.id.qrName)
        textView.text = ReceiveCode.getCode()
        imageView.text = "pyaterochka"
        binding.button.setOnClickListener {
            showQr(codeVal)
        }
    }

    private fun showQr(value: String) {
        val barcode = Barcode(value, BarcodeFormat.QR_CODE)
        barcode.contentColor = ContextCompat.getColor(this, R.color.black)

        Glide.with(this)
            .load(barcode)
            .into(binding.firstQrView)
    }


//    private fun showEan13() {
//        val barcode = Barcode("978020137962", BarcodeFormat.EAN_13)
//        barcode.contentColor = ContextCompat.getColor(this, R.color.black)
//
//        Glide.with(this)
//            .load(barcode)
//            .into(binding.ean13View)
//    }

}