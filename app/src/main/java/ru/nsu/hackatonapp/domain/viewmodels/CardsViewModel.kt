package ru.nsu.hackatonapp.domain.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nsu.hackatonapp.R
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.card.Card
import ru.nsu.hackatonapp.utils.LogTags
import ru.nsu.hackatonapp.utils.UserID

enum class Status { ERROR, SUCCESS, LOADING }

class CardsViewModel(val id: String) : ViewModel() {
    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status
    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards
    init {
        getCards()
    }

    private fun getCards() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try{
                _cards.value = Api.retrofitService.getCards(UserID.userID)
                _status.value = Status.SUCCESS
            } catch (e: Exception){
                Log.d(LogTags.ACTIVITY_CARD, "Error view model")
                _status.value = Status.ERROR
                _cards.value = listOf()

            }
        }
    }
}
