package io.adev.proforientation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView

class AnswerAdapter(val list: List<String>) : RecyclerView.Adapter<AnswerViewHolder>(){

    // [ "Привет" , "Как дела" , "Иди в" ]
    // Переопределяется функция onCreateViewHolder принимая значение parent , которая возвращает
    // AnswerViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        // Определяем переменную layoutInflater и вызываем функцию from у LayoutInflater
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =  layoutInflater.inflate(R.layout.answer_item,parent,false)
        val viewHolder = AnswerViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answerwButton = holder.itemView.findViewById<Button>(R.id.answerButton)
        val answer = list.get(position)
        answerwButton.text = answer
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)