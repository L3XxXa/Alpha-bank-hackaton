package com.example.barcodesprocessing.barcodegenerator.load

import android.graphics.Bitmap
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.signature.ObjectKey
import com.example.barcodesprocessing.barcodegenerator.model.Barcode

class BarcodeModelLoader : ModelLoader<Barcode, Bitmap> {

    override fun buildLoadData(
        barcode: Barcode,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<Bitmap> {
        return ModelLoader.LoadData(
            ObjectKey(barcode),
            BarcodeDataFetcher(barcode, width, height)
        )
    }

    override fun handles(barcode: Barcode): Boolean {
        return true
    }

}