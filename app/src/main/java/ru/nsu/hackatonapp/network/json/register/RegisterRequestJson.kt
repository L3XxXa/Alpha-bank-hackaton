package ru.nsu.hackatonapp.network.json.register

import com.google.gson.annotations.SerializedName

data class RegisterRequestJson(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)