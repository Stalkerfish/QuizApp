package com.stalkerfish.quizapp

object Constants {

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.ic_launcher_background, "Argentina", "Australia","Brazil",
            "Belgium", 1
        )
        questionList.add(que1)

        return questionList
    }
}