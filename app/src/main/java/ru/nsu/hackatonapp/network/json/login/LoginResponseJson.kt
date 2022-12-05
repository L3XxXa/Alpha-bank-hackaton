package ru.nsu.hackatonapp.network.json.login

import com.squareup.moshi.Json

data class LoginResponseJson(@Json(name="result") val result: String, @Json(name="description") val description: String)