package my.app.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var tvInput : TextView? = null
    var lastNumeric: Boolean = false
    var lastDot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }
     fun onClickDigit(view: View){
         tvInput?.append((view as Button).text)
         lastNumeric = true
    }
    fun onClickClear(view: View){
        tvInput?.text = ""
        lastNumeric = false
        lastDot = false
    }
    fun onClickDecimalPoint(view: View){
        if(lastNumeric && !lastDot ){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
    private fun isOpPresent(value: String): Boolean{
        return (value.contains("+") || value.contains("-") || value.contains("*") || value.contains("/"))
    }

    fun onClickOperator(view: View){
            var result: String = tvInput?.text.toString()
            if(result.startsWith("-")) result = result.substring(1)
            if(lastNumeric && !isOpPresent(result)){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
    }
    fun onEqual(view: View){
        try{
            if(lastNumeric){
                var result: String = tvInput?.text.toString()
                var prefix: String = ""
                if(result.startsWith("-")) {
                    prefix = "-"
                    result = result.substring(1)
                }

                if(!(result.contains("+") || result.contains("-") || result.contains("*") || result.contains("/"))) return
                var resultSplit = result.split("-","+","*","/")
                var one = prefix + resultSplit[0]
                var two = resultSplit[1]

                if(result.contains("+")){
                    tvInput?.text = (one.toDouble() + two.toDouble()).toString()
                } else if(result.contains("-")){
                    tvInput?.text = (one.toDouble() - two.toDouble()).toString()
                } else if(result.contains("*")){
                    tvInput?.text = (one.toDouble() * two.toDouble()).toString()
                } else if(result.contains("/")){
                    tvInput?.text = (one.toDouble() / two.toDouble()).toString()
                }
                result = tvInput?.text.toString()
                if(result.substring(result.length-2) == ".0") result = result.substring(0,result.length-2)
                tvInput?.text = result
                //Second way using split
//                resultSplit = result.split(".")
//                one = resultSplit[0]
//                two = resultSplit[1]
//                if(two.toLong() == 0L) tvInput?.text = one
            }
        }catch(e: Exception){
            Toast.makeText(this,"Something Wrong.",Toast.LENGTH_SHORT).show()
        }
    }
}