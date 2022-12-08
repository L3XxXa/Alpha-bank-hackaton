package ru.nsu.hackatonapp.network.json.login

import com.google.gson.annotations.SerializedName


data class LoginResponseJson(
    @SerializedName("id") val userId: String
)
