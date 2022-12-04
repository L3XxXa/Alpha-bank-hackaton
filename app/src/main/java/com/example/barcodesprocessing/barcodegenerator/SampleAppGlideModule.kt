package com.example.barcodesprocessing.barcodegenerator

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.barcodesprocessing.barcodegenerator.GlideBarcode

@GlideModule
class SampleAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        GlideBarcode.registerFactory(registry)
    }

}