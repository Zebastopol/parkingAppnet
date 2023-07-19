package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName

data class ListPatentResponse (

    @SerializedName ("id") val idEntrance: String,
    @SerializedName ("id_empresa") val idCompany:String,
    @SerializedName ("id_libro") val idBook: String,
    @SerializedName ("patente") val patent: ItemPatent,
    @SerializedName ("fecha_ingreso") val dateEntrance: ItemPatent,
    @SerializedName ("hora_ingreso") val timeEntrance: ItemPatent,
    @SerializedName ("fecha_salida") val dateExit: String,
    @SerializedName ("hora_salida") val timeExit: String,
    @SerializedName ("created_at") val createdAt: String,
    @SerializedName ("update_at") val updateAt: String,
    @SerializedName ("estado") val state: String

)