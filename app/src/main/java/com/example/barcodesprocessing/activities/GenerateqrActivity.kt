package com.example.barcodesprocessing.activities

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


class GenerateqrActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var codeVal = ReceiveCode.getCode()
        setContentView(binding.root)
        val textView = findViewById<TextView>(R.id.qrValue)
        val imageView = findViewById<TextView>(R.id.qrName)
        textView.text = ReceiveCode.getCode()
        imageView.text = ReceiveCode.getName()
//        binding.button.setOnClickListener {
            if (codeVal != null) {
                showQr(codeVal)
//            }
        }
    }

    private fun showQr(value: String) {
        val barcode = Barcode(value, BarcodeFormat.QR_CODE)
        barcode.contentColor = ContextCompat.getColor(this, R.color.black)

        Glide.with(this)
            .load(barcode)
            .into(binding.firstQrView)
    }

}