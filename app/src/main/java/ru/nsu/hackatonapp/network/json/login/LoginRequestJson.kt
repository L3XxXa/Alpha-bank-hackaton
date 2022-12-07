package ru.nsu.hackatonapp.network.json.login

import com.google.gson.annotations.SerializedName


data class LoginRequestJson(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
