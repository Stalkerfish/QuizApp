package com.stalkerfish.quizapp

object Constants {

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.brasil, "Argentina", "Australia","Brazil",
            "Belgium", 1
        )
        questionList.add(que1)

        return questionList
    }
}