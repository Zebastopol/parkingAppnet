package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName

data class PatentResponse(
    @SerializedName("operacion")   val operation: String
)