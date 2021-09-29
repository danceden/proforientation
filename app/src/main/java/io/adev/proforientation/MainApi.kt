package io.adev.proforientation

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

//https://2ed7cf8f110e.ngrok.io/
//https://690cd23a5e83.ngrok.io
interface MainApi {
    @GET("question")
    fun getQuestion(@Query("afterId") afterId: String?): Call<Question>

    @POST("answer")
    fun postAnswer(@Body answer: AnswerRequest): Call<Unit>

 
}

// Получить - GET +
// Создать - POST -
// Установить - PUT +
// Изменить - PATCH -
// Удалить - DELETE -