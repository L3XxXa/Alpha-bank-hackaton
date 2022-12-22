package ru.nsu.hackatonapp.network.json.register

import com.google.gson.annotations.SerializedName

data class RegisterResponseJson(
    @SerializedName("result") val result: String,
    @SerializedName("description") val description: String
)