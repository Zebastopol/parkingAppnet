package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("empresa") val empresa: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("username") val username: String?
)