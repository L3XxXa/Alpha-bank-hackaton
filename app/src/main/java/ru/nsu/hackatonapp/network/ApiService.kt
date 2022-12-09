package ru.nsu.hackatonapp.network


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import ru.nsu.hackatonapp.network.json.add_card.AddCardRequestJson
import ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordRequestJson
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordResponseJson
import ru.nsu.hackatonapp.network.json.login.LoginRequestJson
import ru.nsu.hackatonapp.network.json.login.LoginResponseJson
import ru.nsu.hackatonapp.network.json.register.RegisterRequestJson
import ru.nsu.hackatonapp.network.json.register.RegisterResponseJson

private const val baseUrl = "http://192.168.31.98:8080"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl).build()

interface ApiService {
    @POST("/api/user/login")
    suspend fun loginUser(@Body loginRequestJson: LoginRequestJson): Response<LoginResponseJson>

    @POST("/api/user/register")
    suspend fun registerUser(@Body registerRequestJson: RegisterRequestJson): Response<RegisterResponseJson>

    @PUT("/api/user")
    suspend fun changePassword(@Body changePasswordRequestJson: ChangePasswordRequestJson): Response<ChangePasswordResponseJson>

    @POST("/api/card")
    suspend fun addCard(@Body addCardRequestJson: AddCardRequestJson): Response<AddCardResponseJson>

    @GET("/api/card")
    suspend fun getCards()

}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
