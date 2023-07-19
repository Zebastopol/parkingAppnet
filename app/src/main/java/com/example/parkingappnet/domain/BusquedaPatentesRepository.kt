package com.example.parkingappnet.domain

import com.example.parkingappnet.data.model.retrofit.ListPatentResponse
import com.example.parkingappnet.data.network.ParkingApiService
import retrofit2.Response
import javax.inject.Inject


class BusquedaPatentesRepository @Inject constructor(private val patentesApiService: ParkingApiService) {


    suspend fun loadPatentList(token: ListPatentResponse): Boolean {
            val response: Response<List<ListPatentResponse>> = patentesApiService.getPatentList(token="")
            val resultResponse = response.body()
            return response?.isSuccessful == true && resultResponse != null
    }

}

