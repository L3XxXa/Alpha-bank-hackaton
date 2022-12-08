package ru.nsu.hackatonapp.domain.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordRequestJson
import ru.nsu.hackatonapp.network.json.change_password.ChangePasswordResponseJson
import ru.nsu.hackatonapp.repository.ChangePasswordRepository
import ru.nsu.hackatonapp.utils.LogTags

class ChangePasswordViewModel : ViewModel() {
    private val changePasswordRepository = ChangePasswordRepository()
    val result: MutableLiveData<BaseResponse<ChangePasswordResponseJson>> = MutableLiveData()
    fun changePassword(email: String, password: String){
        result.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val request = ChangePasswordRequestJson(email, password)
                val response = changePasswordRepository.changePassword(request)
                if (response.code() == 200){
                    result.value = BaseResponse.Success(response.body())

                }
                else {
                    result.value = BaseResponse.Error(response.message())
                    Log.e(LogTags.RESTORE_PSWD, "Error from viewmodel. Code ${response.code()}. Message $response")
                }
            } catch (e: Exception){
                result.value = BaseResponse.Error(e.message)
            }
        }
    }
}