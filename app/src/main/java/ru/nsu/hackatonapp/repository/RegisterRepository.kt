package ru.nsu.hackatonapp.repository

import retrofit2.Response
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.register.RegisterRequestJson
import ru.nsu.hackatonapp.network.json.register.RegisterResponseJson

class RegisterRepository {
    suspend fun registerUser(registerRequestJson: RegisterRequestJson): Response<RegisterResponseJson>{
        return Api.retrofitService.registerUser(registerRequestJson)
    }
}