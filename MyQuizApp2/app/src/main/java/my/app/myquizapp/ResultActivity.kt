package my.app.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private var name: TextView?= null
    private var score: TextView? = null
    private var btnFinish: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        name = findViewById(R.id.tvName)
        score = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)

        name?.text = intent.getStringExtra(Constants.USER_NAME)

        score?.text = "Your Score is ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)}" +
                "/${intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)}"

        btnFinish?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}