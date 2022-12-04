package ru.nsu.hackatonapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST
import ru.nsu.hackatonapp.network.json.login.LoginResponseJson
import ru.nsu.hackatonapp.network.json.register.RegisterRequestJson

private const val baseUrl = ""
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseUrl).build()

interface ApiService {
    @POST("/api/user/login")
    suspend fun loginUser(): LoginResponseJson
    @POST("/api/user/register")
    suspend fun registerUser(): RegisterRequestJson

}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}