package ru.nsu.hackatonapp.domain.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.network.json.login.LoginRequestJson
import ru.nsu.hackatonapp.network.json.login.LoginResponseJson
import ru.nsu.hackatonapp.repository.LoginRepository

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()
    val loginResult: MutableLiveData<BaseResponse<LoginResponseJson>> = MutableLiveData()
    fun loginUser(email: String, password: String) {
        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequestJson(email, password)
                val response = loginRepository.loginUser(loginRequest)
                if (response.code() == 200) {
                    loginResult.value = BaseResponse.Success(response.body())
                } else {
                    loginResult.value = BaseResponse.Error(response.message())
                }
            } catch (e: Exception) {
                loginResult.value = BaseResponse.Error(e.message)
            }
        }
    }
}