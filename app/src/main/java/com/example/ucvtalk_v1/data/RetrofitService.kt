package com.example.ucvtalk_v1.data

//import com.example.ucvtalk_v1.data.modelDocente.ResultDocente
import com.example.ucvtalk_v1.data.modelEstudiante.ResultEstudiante
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/auth")
    suspend fun ReadAllEstudiantes():ResultEstudiante

//    @POST("")
//    suspend fun InsertEstudiante(
//
//    )
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService{
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}