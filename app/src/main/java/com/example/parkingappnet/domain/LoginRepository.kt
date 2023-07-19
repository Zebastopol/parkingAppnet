package com.example.parkingappnet.domain

import android.util.Log
import com.example.parkingappnet.data.network.ParkingApiService
import com.example.parkingappnet.data.model.retrofit.LoginModel
import com.example.parkingappnet.data.model.retrofit.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val parkingApiService: ParkingApiService) {

        suspend fun validateLog(userLogin: LoginModel): List<LoginResponse>? {
            return withContext(Dispatchers.IO) {                                    //Llama al servicio de autenticación para validar las credenciales.
                val response: Response<List<LoginResponse>> = parkingApiService.login(userLogin)
                val user = response.body()
                if(userLogin != null){                                                              // Si las credenciales son válidas, devuelve el modelo de autenticación
                    user.also { ResponseLogin -> Unit
                        Log.d("RESPONSE LOGIN", ResponseLogin.toString())}
                }else{response.errorBody()?.let {
                    Log.d("EXCEPCIÓN","Ocurrió una excepción durante la carga de usuario:")
                    null}
                }
            }
        }
}