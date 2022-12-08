package ru.nsu.hackatonapp.domain.barcode_parcer

class ReceiveCode {

    companion object {
        private var barcodeCode: String? = null
        private var barcodeName: String? = null

        @JvmName("setName")
        fun setName(name: String) {
            barcodeName = name
            println(name)
        }

        @JvmName("getName")
        fun getName(): String? {
            return barcodeName
        }

        @JvmName("setCode1")
        fun setCode(code: String?) {
            barcodeCode = code
            println(code)
        }

        @JvmName("getCode1")
        fun getCode(): String? {
            return barcodeCode
        }
    }


}