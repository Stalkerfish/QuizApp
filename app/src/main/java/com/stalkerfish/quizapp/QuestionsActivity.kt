package com.stalkerfish.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsActivity : AppCompatActivity() {

    private var questionText: TextView? = null
    private var questionImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null

    private var answer1: TextView? = null
    private var answer2: TextView? = null
    private var answer3: TextView? = null
    private var answer4: TextView? = null

    private var submitBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionText = findViewById(R.id.question_text)
        questionImage = findViewById(R.id.flag)
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)

        answer1 = findViewById(R.id.answer_1)
        answer2 = findViewById(R.id.answer_2)
        answer3 = findViewById(R.id.answer_3)
        answer4 = findViewById(R.id.answer_4)

        val questionsList = Constants.getQuestions()

        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]

        questionText?.text = question.question
        questionImage?.setImageResource(question.image)

        progressBar?.progress = currentPosition
        progressText?.text = "${currentPosition}/${progressBar?.max}"
        
        answer1?.text = question.optionOne
        answer2?.text = question.optionTwo
        answer3?.text = question.optionThree
        answer4?.text = question.optionFour
    }
}