package io.adev.proforientation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuestionFragment : Fragment(R.layout.question_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val answerRecycler: RecyclerView = view.findViewById(R.id.answerRecycler)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://a8a01126fc8a.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build();

        val api = retrofit.create(MainApi::class.java)

        api.getAnswers().enqueue(object : Callback<Question> {
            override fun onFailure(call: Call<Question>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                answerRecycler.adapter =
                    AnswerAdapter(list = response.body() ?.answers ?: listOf())
            }
        })
    }
}
