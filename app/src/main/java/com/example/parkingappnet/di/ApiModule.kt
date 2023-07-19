package com.example.parkingappnet.di

//import com.example.parkingappnet.data.network.PatenteApiService
import com.example.parkingappnet.data.network.ParkingApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun retrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl("https://appnetstore.cl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesUsuarioApiService(retrofit: Retrofit): ParkingApiService {
        return retrofit.create(ParkingApiService::class.java)
    }
}
   /* @Provides
    @Singleton
    fun requestBody(): RequestBody {
        val requestBody = FormBody.Builder()
            .add("usuario", "datos")
            .add("empresa", "datos")
            .add("password", "datos").build()
        return requestBody
    }*/

    /*providesPatenteApiService(retrofit: Retrofit): PatenteApiService {
        return retrofit.create(PatenteApiService::class.java)
    }
}*/
//CÓDIGO SUGERIDO CHAT-GPT


// En alguna parte de tu código...
/*val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor(authToken))
            .build()
    )
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val loginService = retrofit.create(LoginService::class.java)
val response = loginService.login(credentials)
*/