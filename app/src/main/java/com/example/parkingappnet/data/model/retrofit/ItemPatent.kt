package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName


data class ItemPatent(
     //@SerializedName("token")   val token: AuthModel,
     @SerializedName("patente") val idPatent: String,
     @SerializedName("fecha_ingreso") val dateEntrance: String,
     @SerializedName("hora_ingreso") val timeEntrance: String,
     @SerializedName("estado") val state: String
)

