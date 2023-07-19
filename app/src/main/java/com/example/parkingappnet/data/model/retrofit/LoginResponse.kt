package com.example.parkingappnet.data.model.retrofit

import com.google.gson.annotations.SerializedName


data class LoginResponse (
        @SerializedName("Token") val token:String, //"eb94ab6c3532f7a3da47cd3ded7a0c37658c8896672600124f8e20ed134afa54fec79c75bf01c1811a419f7d4c9d25b074be094b96e6de13e51600d94acc7902",
        @SerializedName("id_bodega") val idbodega:String, //"1"
        @SerializedName("tipo") val tipouser:String,// "admin"
        @SerializedName("Nombre") val nomuser:String,// "Demo Demo"
        @SerializedName("bodega") val nombodega:String, //"BODEGA PRINCIPAL"
        @SerializedName("sucursal") val nomsucursal:String,//"CASA MATRIZ"
        @SerializedName("rut") val rut:String,// "19161665-0
        @SerializedName("id_user") val iduser:Int,// "3"
        @SerializedName("id_empresa") val idempresa:String//"1"
)




