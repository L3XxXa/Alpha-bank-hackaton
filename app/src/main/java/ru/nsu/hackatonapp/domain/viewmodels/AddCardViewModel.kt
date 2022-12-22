package ru.nsu.hackatonapp.domain.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.network.BaseResponse
import ru.nsu.hackatonapp.network.json.add_card.AddCardRequestJson
import ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson
import ru.nsu.hackatonapp.repository.AddCardRepository
import ru.nsu.hackatonapp.utils.LogTags

class AddCardViewModel : ViewModel() {
    private val addCardRepository = AddCardRepository()
    val result: MutableLiveData<BaseResponse<AddCardResponseJson>> = MutableLiveData()
    fun addCard(userId: String, name: String, number: String, priority: String) {
        result.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val request = AddCardRequestJson(name, number, priority, userId)
                val response = addCardRepository.addCard(request)
                if (response.code() == 200) {
                    result.value = BaseResponse.Success(response.body())
                } else {
                    result.value = BaseResponse.Error(response.message())
                    Log.e(LogTags.ADD_CARD, "Error from viewmodel. Code ${response.code()}. Message $response")
                }
            } catch (e: Exception) {
                result.value = BaseResponse.Error(e.message)
            }
        }
    }
}