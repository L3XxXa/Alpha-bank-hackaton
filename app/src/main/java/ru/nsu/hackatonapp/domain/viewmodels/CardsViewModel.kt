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

class CardsViewModel() : ViewModel() {
    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status
    private val _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards
    var debugCards = ArrayList<Card>()
    init {
        Log.d(LogTags.ACTIVITY_CARD, "LOASDAsdjksahfuhsaduifhuadsSDASDSA")

        getCards()
    }

    private fun getCards() {
        Log.d(LogTags.ACTIVITY_CARD, "LOASDASDASDSA")
        viewModelScope.launch {
            _status.value = Status.LOADING
            try{
                _cards.value = Api.retrofitService.getCards(UserID.userID)
                debugCards = Api.retrofitService.getCards(UserID.userID) as ArrayList<Card>
                Log.d(LogTags.ACTIVITY_CARD, "debug cards $debugCards")
                Log.d(LogTags.ACTIVITY_CARD, "value ${cards.value}")
                _status.value = Status.SUCCESS
                Log.d(LogTags.ACTIVITY_CARD, "${_status.value}")
            } catch (e: Exception){
                Log.d(LogTags.ACTIVITY_CARD, "Error view model")
                _status.value = Status.ERROR
                _cards.value = listOf()

            }
        }
    }
}
