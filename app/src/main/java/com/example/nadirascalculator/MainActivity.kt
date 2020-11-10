package com.example.nadirascalculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View){

        if(view is TextView){

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if(result == "0"){
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun dotClick(view: View) {

        if (resultTextView.text.toString().contains(".")) {

            var d = resultTextView.text.toString()
            d += "."
            resultTextView.text = d
        }
    }
    fun operationClick(view: View){

        if(view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""

            operation = view.text.toString()

        }

    }

    fun equalsClick(view: View){

        val secOperandText = resultTextView.text.toString()
        var secOperand:Double = 0.0
        if(!TextUtils.isEmpty(secOperandText)){
            secOperand = secOperandText.toDouble()
        }

        when(operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "x" -> resultTextView.text = (operand * secOperand).toString()
            "÷" -> resultTextView.text = (operand / secOperand).toString()
            "√" -> resultTextView.text = (operand.pow(0.5)).toString()
            "%" -> resultTextView.text = (operand / 100).toString()
            "^" -> resultTextView.text = (operand.pow(secOperand)).toString()

        }

    }

    fun clearClick(view: View){
        resultTextView.text = ""
    }
    fun backspace(view: View){

        var b = resultTextView.text.toString()
        if(!TextUtils.isEmpty(b)){
            resultTextView.text = b.substring(0,b.length - 1)
        }


    }
}

    