package com.example.parkingappnet.data.network

import com.example.parkingappnet.data.model.retrofit.*
import retrofit2.Response
import retrofit2.http.*

interface ParkingApiService {

    @Headers("content-type:  application/json")
    @POST("login")
    suspend fun login(@Body loginRequest: LoginModel): Response<List<LoginResponse>>

    @Headers("content-type:  application/json")
    @POST("parking/arrive")
    suspend fun parkingArrive(@Header("token") token: String, @Body patentRequest: ItemPatent): Response<PatentResponse>

    @GET("parking/dia")
    suspend fun getPatentList(@Header("token") token: String): Response<List<ListPatentResponse>>

}