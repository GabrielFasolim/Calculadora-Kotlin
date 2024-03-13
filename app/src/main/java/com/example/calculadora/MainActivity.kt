package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.calculadora.R


class MainActivity : AppCompatActivity() {

    private lateinit var numberInput1: EditText
    private lateinit var numberInput2: EditText
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberInput1 = findViewById(R.id.numberInput1)
        numberInput2 = findViewById(R.id.numberInput2)
        resultText = findViewById(R.id.resultText)
    }

    fun onAddClick(view: View) {
        calculateResult("+")
    }

    fun onSubtractClick(view: View) {
        calculateResult("-")
    }

    fun onMultiplyClick(view: View) {
        calculateResult("*")
    }

    fun onDivideClick(view: View) {
        calculateResult("/")
    }

    private fun calculateResult(operator: String) {
        val input1Str = numberInput1.text.toString()
        val input2Str = numberInput2.text.toString()

        if (input1Str.isEmpty() || input2Str.isEmpty()) {
            Toast.makeText(this, "Preencha ambos os números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = input1Str.toDouble()
        val num2 = input2Str.toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = num1 + num2
            "-" -> result = num1 - num2
            "*" -> result = num1 * num2
            "/" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = num1 / num2
            }
        }

        resultText.text = result.toString()
    }
}
