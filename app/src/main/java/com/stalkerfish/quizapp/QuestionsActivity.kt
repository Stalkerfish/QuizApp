package com.stalkerfish.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionsList = Constants.getQuestions()
        Log.i("QuestionsList size is", "${questionsList.size}")
    }
}