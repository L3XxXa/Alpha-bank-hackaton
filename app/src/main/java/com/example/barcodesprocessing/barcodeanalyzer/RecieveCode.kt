package com.example.barcodesprocessing.barcodeanalyzer

class ReceiveCode {

    companion object {
        private var barcodeCode = "1234567890"

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