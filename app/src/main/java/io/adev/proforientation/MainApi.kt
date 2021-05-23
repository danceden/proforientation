package io.adev.proforientation

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://gist.githubusercontent.com/danceden/72a7db214bea35c3a989bb328fe536af/raw/8de5e114f35bbb97fb8c324bcba08c89bb6be746/answers.json

interface MainApi {
    @GET("answer")
    fun getAnswers(): Call<Question>


}

// Получить - GET +
// Создать - POST -
// Установить - PUT +
// Изменить - PATCH -
// Удалить - DELETE -