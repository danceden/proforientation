package io.adev.proforientation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnswerAdapter(
    private val callback: Callback,
    private val question: Question
) : RecyclerView.Adapter<AnswerViewHolder>() {

    // [ "Привет" , "Как дела" , "Иди в" ]
    // Переопределяется функция onCreateViewHolder принимая значение parent , которая возвращает
    // AnswerViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        // Определяем переменную layoutInflater и вызываем функцию from у LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.answer_item, parent, false)
        val viewHolder = AnswerViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answer = question.answers.get(position)
        val answerID = answer.id
        val questionID = question.id
        holder.answerButton.text = answer.text
        holder.answerButton.setOnClickListener {
            callback.onAnswerClick(questionID, answerID)
        }
        //answerButton.setOnClickListener { api.postAnswer(answer = AnswerRequest() }
    }

    override fun getItemCount(): Int {
        return question.answers.size
    }

    interface Callback {
        fun onAnswerClick(answerID: String, questionID: String)
    }


}

class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val answerButton: Button = itemView.findViewById(R.id.answerButton)
}