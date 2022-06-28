package my.app.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName= findViewById<EditText>(R.id.editText)
        btnStart.setOnClickListener{
            if(etName.text.isEmpty()){
                Toast.makeText(this,"Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuestionForQUiz::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}