package com.example.parkingappnet.data.model

sealed class ApiState<T, Q>{

    class Success<T, Q>(val value: T): ApiState<T, Q>()
    class Error<T, Q>(val value: T): ApiState<T, Q>()
    class Loading<T, Q>(val value: T): ApiState<T, Q>()



}