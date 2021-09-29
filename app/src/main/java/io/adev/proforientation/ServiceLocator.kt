package io.adev.proforientation

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {
    fun mainApi(): MainApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://690cd23a5e83.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofit.create(MainApi::class.java)
    }

}