package io.adev.proforientation

data class Question(
    val text: String,
    val answers: List<Answer>
) {
    data class Answer(
        val id: String,
        val text: String
    )
}