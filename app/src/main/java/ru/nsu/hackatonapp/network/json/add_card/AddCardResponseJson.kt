package ru.nsu.hackatonapp.network.json.add_card

import com.google.gson.annotations.SerializedName

data class AddCardResponseJson(
    @SerializedName("result") val result: String,
    @SerializedName("description") val description: String
)
