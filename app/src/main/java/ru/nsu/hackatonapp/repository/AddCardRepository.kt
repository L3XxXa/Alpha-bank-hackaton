package ru.nsu.hackatonapp.repository

import retrofit2.Response
import ru.nsu.hackatonapp.network.Api
import ru.nsu.hackatonapp.network.json.add_card.AddCardRequestJson
import ru.nsu.hackatonapp.network.json.add_card.AddCardResponseJson

class AddCardRepository {
    suspend fun addCard(addCardRequestJson: AddCardRequestJson) : Response<AddCardResponseJson>{
        return Api.retrofitService.addCard(addCardRequestJson)
    }
}