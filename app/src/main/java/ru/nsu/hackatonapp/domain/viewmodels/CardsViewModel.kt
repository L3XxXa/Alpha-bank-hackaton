package ru.nsu.hackatonapp.domain.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.card.Card

enum class Status {LOADING, ERROR, SUCCESS}

class CardsViewModel() : ViewModel() {
    private val _cards = MutableLiveData<List<Card>>()
    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status> = _status
    val result : LiveData<List<Card>> = _cards

    fun getPhotos(userId: String){
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _cards.value = Api.retrofitService.getCards(userId)
                _status.value = Status.SUCCESS
            } catch (e: Exception){
                _status.value = Status.ERROR
                _cards.value = listOf()
            }
        }
    }
}