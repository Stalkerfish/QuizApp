package com.stalkerfish.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 1

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

        answer1?.setOnClickListener(this)
        answer2?.setOnClickListener(this)
        answer3?.setOnClickListener(this)
        answer4?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        answer1?.let {
            options.add(0, it)
        }
        answer2?.let {
            options.add(1, it)
        }
        answer3?.let {
            options.add(2, it)
        }
        answer4?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.WHITE)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.border_bg)
        }

    }

    private fun selectedOptionsView(option: TextView, optionNumber: Int){
        defaultOptionsView()

        mSelectedOptionPosition = optionNumber

        option.setTextColor(Color.parseColor("#363A43"))
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(this, R.drawable.selected_border_bg)
    }

    private fun setQuestion() {
        defaultOptionsView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]

        questionText?.text = question.question
        questionImage?.setImageResource(question.image)

        progressBar?.progress = mCurrentPosition
        progressText?.text = "${mCurrentPosition}/${progressBar?.max}"

        answer1?.text = question.optionOne
        answer2?.text = question.optionTwo
        answer3?.text = question.optionThree
        answer4?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size){
            submitBtn?.text = "FINISH"

        }else{
            submitBtn?.text = "SUBMIT"
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.answer_1 -> answer1?.let {
                selectedOptionsView(it, 1)
            }
            R.id.answer_2 -> answer2?.let {
                selectedOptionsView(it, 2)
            }
            R.id.answer_3 -> answer3?.let {
                selectedOptionsView(it, 3)
            }
            R.id.answer_4 -> answer4?.let {
                selectedOptionsView(it, 4)
            }
            R.id.submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size ->
                            setQuestion()

                        else -> {
                            MotionToast.createToast(this, null,
                                "Congrats! You made it!",
                                MotionToastStyle.SUCCESS, MotionToast.GRAVITY_BOTTOM,
                                MotionToast.LONG_DURATION, Typeface.SANS_SERIF)
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition)
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_border_bg)

                    answerView(question.correctAnswer, R.drawable.correct_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size)
                        submitBtn?.text = "FINISH"

                    else
                        submitBtn?.text = "GO TO NEXT QUESTION"

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawable: Int){
        when(answer){
            1 -> answer1?.background = ContextCompat.getDrawable(
                this, drawable)

            2 -> answer2?.background = ContextCompat.getDrawable(
                this, drawable)

            3 -> answer3?.background = ContextCompat.getDrawable(
                this, drawable)

            4 -> answer4?.background = ContextCompat.getDrawable(
                this, drawable)
        }
    }
}