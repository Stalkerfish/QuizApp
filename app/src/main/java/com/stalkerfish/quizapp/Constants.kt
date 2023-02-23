package com.stalkerfish.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_questions"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.brasil, "Argentina", "Australia","Brazil",
            "Belgium", 3
        )
        questionList.add(que1)

        val que2 = Question(
            2,"What is in this image?",
            R.drawable.ic_trophy, "Fred Nicácio", "Trophy","House",
            "Sri Lanka", 2
        )
        questionList.add(que2)

        val que3 = Question(
            3,"What is this?",
            R.drawable.h2o, "Water", "Molecule","Formula",
            "Soda Brand", 4
        )
        questionList.add(que3)

        return questionList
    }
}