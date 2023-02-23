package com.stalkerfish.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val userName: TextView? = findViewById(R.id.user)
        val results: TextView? = findViewById(R.id.results)
        val finishButton: Button? = findViewById(R.id.finishButton)

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        val name = intent.getStringExtra(Constants.USER_NAME)

        userName?.text = "$name!"
        results?.text = "Your score is $correctAnswers out of $totalQuestion"

        finishButton?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}