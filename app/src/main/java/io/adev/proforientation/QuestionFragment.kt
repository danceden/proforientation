package io.adev.proforientation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView

class QuestionFragment : Fragment(R.layout.question_fragment) {
    private val viewModel by viewModels<QuestionViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText = view.findViewById<TextView>(R.id.questionText)
        val answerRecycler: RecyclerView = view.findViewById(R.id.answerRecycler)
        viewModel.isClosedLiveData.observe(viewLifecycleOwner){ isClosed ->
            if(isClosed){
                requireActivity().supportFragmentManager.popBackStack()
            }
        }
        viewModel.questionLiveData.observe(viewLifecycleOwner){question ->
            if(question != null){
                questionText.setText(question.text)
                answerRecycler.adapter =
                    AnswerAdapter(
                        question = question,
                        callback = object : AnswerAdapter.Callback {
                            override fun onAnswerClick(
                                answerID: String,
                                questionID: String
                            ) {
                                viewModel.onAnswerClick(answerID, questionID)
                            }
                        })
            }
        }
        viewModel.init()
    }



}
// acmp.ru - на сортировку и последовательности
// джэик уортон почитать статьи