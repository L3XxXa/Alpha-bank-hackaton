package ru.nsu.hackatonapp.repository

import retrofit2.Response
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordRequestJson
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordResponseJson

class ChangePasswordRepository {
    suspend fun changePassword(changePasswordRequestJson: ChangePasswordRequestJson) : Response<ChangePasswordResponseJson>{
        return Api.retrofitService.changePassword(changePasswordRequestJson)
    }
}