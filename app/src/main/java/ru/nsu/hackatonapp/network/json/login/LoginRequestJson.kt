package ru.nsu.hackatonapp.network.json.login

import com.squareup.moshi.Json

data class LoginRequestJson(@Json(name = "email") val email: String, @Json(name="password") val password: String)
