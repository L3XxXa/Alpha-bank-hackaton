package ru.nsu.hackatonapp.network.json.change_password

import com.google.gson.annotations.SerializedName

data class ChangePasswordRequestJson(
    @SerializedName("email") val email: String,
    @SerializedName("password") val newPassword: String
)