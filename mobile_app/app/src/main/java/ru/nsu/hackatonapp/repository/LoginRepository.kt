package ru.nsu.hackatonapp.repository

import retrofit2.Response
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.login.LoginRequestJson
import ru.nsu.hackatonapp.network.json.login.LoginResponseJson

class LoginRepository {
    suspend fun loginUser(loginRequestJson: LoginRequestJson): Response<LoginResponseJson> {
        return Api.retrofitService.loginUser(loginRequestJson)
    }
}