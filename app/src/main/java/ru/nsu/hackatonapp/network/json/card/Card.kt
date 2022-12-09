package ru.nsu.hackatonapp.network.json.card

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String,
    @SerializedName("priority") val priority: String,
    @SerializedName("distanceToNearest") val distanceToNearest: String,
    @SerializedName("userId") val userId: String
)
