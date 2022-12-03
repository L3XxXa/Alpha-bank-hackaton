package com.example.barcodesprocessing.barcode

class ReceiveCode {

    companion object {
        private var barcodeCode = ""

        @JvmName("setCode1")
        fun setCode(code: String) {
            barcodeCode = code
            println(code)
        }

        @JvmName("getCode1")
        fun getCode(): String {
            return barcodeCode
        }
    }


}