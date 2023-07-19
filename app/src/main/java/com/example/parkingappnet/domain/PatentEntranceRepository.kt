package com.example.parkingappnet.domain

import com.example.parkingappnet.data.model.retrofit.ItemPatent
import com.example.parkingappnet.data.model.retrofit.PatentResponse
import com.example.parkingappnet.data.model.retrofit.AuthModel
import com.example.parkingappnet.data.network.ParkingApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class PatentEntranceRepository @Inject constructor(private val parkingApiService: ParkingApiService) {

    suspend fun newPatent(requestPatent: ItemPatent): Boolean? {
            //agregar método try-catch para manejar errores
            val response: Response<PatentResponse> = parkingApiService.parkingArrive(token = "",requestPatent)
            val resultResponse = response.body()
            return response.isSuccessful && resultResponse != null

        }
    }
    //DEVOLVER LOS DATOS DE LA BASE DE DATOS PARA EL VIEWMODEL: PATENTES + FECHAS DE INGRESO + HORA DE INGRESO + ESTADO DE LA PATENTE


