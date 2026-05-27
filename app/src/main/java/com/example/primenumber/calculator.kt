package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.primenumber.R

class calculator : AppCompatActivity() {

    lateinit var ans: TextView
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var ac: Button
    lateinit var n1: Button
    lateinit var n2: Button
    lateinit var n3: Button
    lateinit var n4: Button
    lateinit var n5: Button
    lateinit var n6: Button
    lateinit var n7: Button
    lateinit var n8: Button
    lateinit var n9: Button
    lateinit var n0: Button
    lateinit var plus: Button
    lateinit var minus: Button
    lateinit var multiply: Button
    lateinit var divide: Button
    lateinit var equalto: Button
    var firstNumber = ""
    var secondNumber = ""
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        ans = findViewById(R.id.ans)
        ac = findViewById(R.id.ac)
        n1 = findViewById(R.id.one)
        n2 = findViewById(R.id.two)
        n3 = findViewById(R.id.three)
        n4 = findViewById(R.id.four)
        n5 = findViewById(R.id.five)
        n6 = findViewById(R.id.six)
        n7 = findViewById(R.id.seven)
        n8 = findViewById(R.id.eight)
        n9 = findViewById(R.id.nine)
        n0 = findViewById(R.id.zero)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        equalto = findViewById(R.id.equalto)
        fun updateDisplay() {
            ans.text = firstNumber + operator + secondNumber
        }
        fun calculate() {
            if(firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                var num1 = firstNumber.toInt()
                var num2 = secondNumber.toInt()
                var result = 0
                when(operator) {
                    "+" -> result = num1 + num2
                    "-" -> result = num1 - num2
                    "*" -> result = num1 * num2
                    "/" -> {

                        if(num2 != 0) {
                            result = num1 / num2
                        }
                        else {
                            ans.text = "Cannot divide by zero"
                            return
                        }
                    }
                }

                ans.text = result.toString()

                firstNumber = result.toString()
                secondNumber = ""
            }
        }
        fun addNumber(number: String) {

            if(operator == "") {

                firstNumber += number
            }
            else {

                secondNumber += number
            }

            updateDisplay()
        }
        n0.setOnClickListener { addNumber("0") }
        n1.setOnClickListener { addNumber("1") }
        n2.setOnClickListener { addNumber("2") }
        n3.setOnClickListener { addNumber("3") }
        n4.setOnClickListener { addNumber("4") }
        n5.setOnClickListener { addNumber("5") }
        n6.setOnClickListener { addNumber("6") }
        n7.setOnClickListener { addNumber("7") }
        n8.setOnClickListener { addNumber("8") }
        n9.setOnClickListener { addNumber("9") }
        plus.setOnClickListener {
            operator = "+"
            updateDisplay()
        }
        minus.setOnClickListener {
            operator = "-"
            updateDisplay()
        }
        multiply.setOnClickListener {
            operator = "*"
            updateDisplay()
        }
        divide.setOnClickListener {
            operator = "/"
            updateDisplay()
        }
        equalto.setOnClickListener {
            calculate()
        }
        ac.setOnClickListener {
            firstNumber = ""
            secondNumber = ""
            operator = ""
            ans.text = ""
        }
        button2=findViewById(R.id.prime)
        button3=findViewById(R.id.fact)
        var intent=Intent(this,prime::class.java)

        button2.setOnClickListener {
            startActivity(intent)
        }
        var intent2=Intent(this,factorial::class.java)

        button3.setOnClickListener {
            startActivity(intent2)
        }
    }
}