package ru.nsu.hackatonapp.network.json.add_card

import com.google.gson.annotations.SerializedName

data class AddCardRequestJson(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String,
    @SerializedName("priority") val priority: String,
    @SerializedName("userId") val userId: String

)
