package com.example.barcodesprocessing.barcodegenerator

import android.graphics.Bitmap
import com.bumptech.glide.Registry
import com.example.barcodesprocessing.barcodegenerator.model.Barcode
import com.example.barcodesprocessing.barcodegenerator.load.BarcodeModelLoaderFactory

open class GlideBarcode {

    companion object {

        fun registerFactory(registry: Registry) {
            registry.prepend(
                Barcode::class.java,
                Bitmap::class.java,
                BarcodeModelLoaderFactory()
            )
        }

    }

}



