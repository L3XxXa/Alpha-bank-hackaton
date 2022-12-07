package ru.nsu.hackatonapp.network.json.change_password

import com.google.gson.annotations.SerializedName

data class ChangePasswordResponseJson(@SerializedName("result") val result: String, @SerializedName("description") val description: String)