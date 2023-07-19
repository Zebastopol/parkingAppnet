package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName

data class AuthModel(

    @SerializedName("Token")  val token: String
)