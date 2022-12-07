package ru.nsu.hackatonapp.domain.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.network.json.register.RegisterRequestJson
import ru.nsu.hackatonapp.network.json.register.RegisterResponseJson
import ru.nsu.hackatonapp.repository.RegisterRepository
import ru.nsu.hackatonapp.utils.LogTags

class RegisterViewModel: ViewModel() {
    private val registerRepository = RegisterRepository()
    val registerResult = MutableLiveData<BaseResponse<RegisterResponseJson>>()

    fun registerUser(email: String, password: String){
        registerResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val registerRequest = RegisterRequestJson(email, password)
                val response = registerRepository.registerUser(registerRequest)
                if (response.code() == 200) {
                    registerResult.value = BaseResponse.Success(response.body())
                } else {
                    registerResult.value = BaseResponse.Error(response.message())
                    Log.e(
                        LogTags.REGISTRATION,
                        "Error from viewmodel. Code ${response.code()}. Message ${response.message()}"
                    )
                }
            } catch (e: Exception){
                registerResult.value = BaseResponse.Error(e.message)
            }
        }
    }
}