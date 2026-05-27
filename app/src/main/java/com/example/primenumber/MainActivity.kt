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

class MainActivity : AppCompatActivity() {
    lateinit var fact:Button
    lateinit var prime1:Button
    lateinit var calc:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        fact=findViewById(R.id.fact)
        prime1=findViewById(R.id.prime)
        calc=findViewById(R.id.calc)

        var factorial= Intent(this,factorial::class.java)
        var prim=Intent(this,prime::class.java)
        var calculator= Intent(this,calculator::class.java)

        fact.setOnClickListener {
            startActivity(factorial)
        }
        prime1.setOnClickListener {
            startActivity(prim)
        }
        calc.setOnClickListener {
            startActivity(calculator)
        }
    }
}