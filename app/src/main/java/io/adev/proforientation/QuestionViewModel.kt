package io.adev.proforientation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class QuestionViewModel : ViewModel()  {
    val isClosedLiveData = MutableLiveData<Boolean>(false)
    val questionLiveData = MutableLiveData<Question?>(null)
    private val api = ServiceLocator.mainApi()

    fun init(){
        getQuestion(afterId = null)
    }

    fun onAnswerClick(
        answerID: String,
        questionID: String
        ) {
            api.postAnswer(
                AnswerRequest(
                    questionID,
                    answerID
                )
            ).enqueue(object : Callback<Unit> {
                override fun onFailure(
                    call: Call<Unit>,
                    t: Throwable
                ) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<Unit>,
                    response: Response<Unit>
                ) {
                    getQuestion(afterId = questionID)
                }
            })
    }

    fun getQuestion(afterId : String?){

        api.getQuestion(afterId = afterId).enqueue(object : Callback<Question> {
            override fun onFailure(call: Call<Question>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                val question = response.body()!!
                questionLiveData.value = question

            }
        })
    }



}