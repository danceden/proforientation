package io.adev.proforientation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class QuestionFragment : Fragment(R.layout.question_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextQuestionButton: Button = view.findViewById(R.id.nextQuestionButton)
        nextQuestionButton.setOnClickListener {
            requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, QuestionFragment())
                    .addToBackStack(null)
                    .commit()
        }
    }
}
