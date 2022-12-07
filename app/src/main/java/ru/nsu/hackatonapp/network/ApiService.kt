package ru.nsu.hackatonapp.network


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import ru.nsu.hackatonapp.network.json.login.LoginRequestJson
import ru.nsu.hackatonapp.network.json.login.LoginResponseJson
import ru.nsu.hackatonapp.network.json.register.RegisterRequestJson
import ru.nsu.hackatonapp.network.json.register.RegisterResponseJson

private const val baseUrl = "http://192.168.43.86:8080"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl).build()

interface ApiService {
    @POST("/api/user/login")
    suspend fun loginUser(@Body loginRequestJson: LoginRequestJson): Response<LoginResponseJson>

    @POST("/api/user/register")
    suspend fun registerUser(@Body registerRequestJson: RegisterRequestJson): Response<RegisterResponseJson>

}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}