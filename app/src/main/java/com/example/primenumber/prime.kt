package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primenumber.R

class prime: AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var tv: TextView
    lateinit var edit1: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.prime)
        button1=findViewById(R.id.click)
        edit1 = findViewById(R.id.num)
        tv = findViewById(R.id.ans)

        button1.setOnClickListener {
            var s : String = edit1.text.toString()
            var n:Int = Integer.parseInt(s)
            var ans:Int=0
            for(i in 2..n-1){
                if(n%i==0){
                    ans=1;
                }
            }
            if(ans==0){
                tv.setText("${n} is a Prime Number")
            }
            else
            {
                tv.setText("${n} is not a Prime Number")
            }
        }
        button2=findViewById(R.id.fact)
        button3=findViewById(R.id.calc)
        var intent=Intent(this,factorial::class.java)

        button2.setOnClickListener {
            startActivity(intent)
        }
        var intent2=Intent(this,calculator::class.java)

        button3.setOnClickListener {
            startActivity(intent2)
        }

    }
}