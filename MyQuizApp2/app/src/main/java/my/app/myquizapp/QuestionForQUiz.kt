package my.app.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionForQUiz : AppCompatActivity(), View.OnClickListener {
    private var opOne: TextView? = null
    private var opTwo: TextView? = null
    private var opThree: TextView? = null
    private var opFour: TextView? = null
    private var pbId: TextView? = null
    private lateinit var options: ArrayList<TextView?>
    private var progressBar : ProgressBar? = null
    private var flag : ImageView? = null
    private var question: TextView? = null
    private var btnSubmit: Button? = null
    private var currentQuestionIndex: Int = 0
    private var selectedOptionIndex: Int = 0
    private lateinit var questionList: List<Question>
    private var uName: String? = null
    private var totalQuestions: Int = 0
    private var correctAnswers: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_for_quiz)
        // References
         opOne = findViewById(R.id.optionOne)
         opTwo = findViewById(R.id.optionTwo)
        opThree = findViewById(R.id.optionThree)
         opFour = findViewById(R.id.optionFour)
         progressBar = findViewById(R.id.pb)
        pbId = findViewById(R.id.tvPbId)
         flag = findViewById(R.id.ivFlag)
        question = findViewById(R.id.tvQuestion)
         btnSubmit = findViewById(R.id.btnSubmit)
        // -----------------------------------------------
        questionList = Constants.getQuestions()
        totalQuestions = questionList.size
        uName = intent.getStringExtra(Constants.USER_NAME)

        //-------------------------------------------------
        changeUi(questionList[currentQuestionIndex])
        opOne?.setOnClickListener(this)
        opTwo?.setOnClickListener(this)
        opThree?.setOnClickListener(this)
        opFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }
    private fun defaultOptionsView(){
        options = ArrayList()
        options.add(0,opOne)
        options.add(1,opTwo)
        options.add(2,opThree)
        options.add(3,opFour)
        for(i in options.indices) {
            options[i]?.let {
                it.typeface = Typeface.DEFAULT
                it.setTextColor(Color.parseColor("#363A43"))
                it.background = ContextCompat.getDrawable(
                    this, R.drawable.option_background
                )
            }
        }
        btnSubmit?.text = "SUBMIT"
    }
    private fun selectedOptionView(view:TextView?,selectOption: Int){
        defaultOptionsView()
        view?.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border_bg)
        view?.setTextColor(Color.parseColor("#FF0000"))
        view?.setTypeface(view.typeface, Typeface.BOLD)
        selectedOptionIndex = selectOption
    }
    private fun changeUi(ques: Question){
        defaultOptionsView()
        selectedOptionIndex = 0
        question?.text = ques.question
        flag?.setImageResource(ques.image)
        progressBar?.progress = (currentQuestionIndex+1)
        pbId?.text = "${currentQuestionIndex+1}/${questionList.size}"
        opOne?.text = ques.optionOne
        opTwo?.text = ques.optionTwo
        opThree?.text = ques.optionThree
        opFour?.text = ques.optionFour
    }
    private fun revertOnClickView(){
        for(option in options) {
            option?.let{
                it.isEnabled = !(it.isEnabled)
            }
        }
    }
    private fun checkAnswer(){
        revertOnClickView()
        val correctIndex = questionList[currentQuestionIndex].CorrectAnswer - 1
        val selectedIndex = selectedOptionIndex - 1

        if(selectedIndex != correctIndex){
            options[selectedIndex]?.background = ContextCompat.getDrawable(
                this,R.drawable.wrong_option
            )
            options[selectedIndex]?.setTextColor(Color.parseColor("#FFFFFF"))
            options[selectedIndex]?.setTypeface(options[selectedIndex]?.typeface,Typeface.BOLD)
        }else{
            correctAnswers++;
        }
        options[correctIndex]?.background = ContextCompat.getDrawable(
            this,R.drawable.correct_option
        )
        options[correctIndex]?.setTextColor(Color.parseColor("#FFFFFF"))
        options[correctIndex]?.setTypeface(options[correctIndex]?.typeface,Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            opOne?.id ->{
                selectedOptionView(opOne,1)
            }
            opTwo?.id ->{
                selectedOptionView(opTwo,2)
            }
            opThree?.id ->{
                selectedOptionView(opThree,3)
            }
            opFour?.id ->{
                selectedOptionView(opFour,4)
            }
            btnSubmit?.id ->{
                if(currentQuestionIndex == questionList.size){
                    val intent = Intent(this,ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME,uName)
                    intent.putExtra(Constants.TOTAL_QUESTIONS,totalQuestions)
                    intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswers)
                    startActivity(intent)
                    finish()
                }else if(selectedOptionIndex == 0){
                    Toast.makeText(this,"Select an Option.",Toast.LENGTH_LONG).show()
                }else if(opOne?.isEnabled == true){
                    checkAnswer()
                    if(currentQuestionIndex < questionList.size - 1){
                        btnSubmit?.text = "Go To next Question."
                    }else {
                        btnSubmit?.text = "Check Result"
                        currentQuestionIndex++
                    }
                }else {
                    currentQuestionIndex++
                    if(currentQuestionIndex != questionList.size) {
                        revertOnClickView()
                        changeUi(questionList[currentQuestionIndex])
                    }
                }
            }
        }
    }
}