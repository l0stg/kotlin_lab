package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SqrCalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqr_calc)
        val button_calc_x = findViewById<Button>(R.id.calc_x)
        button_calc_x.setOnClickListener{

                val a: Int = findViewById<EditText>(R.id.editA).text.toString().toInt()
                val b: Int = findViewById<EditText>(R.id.editB).text.toString().toInt()
                val c: Int = findViewById<EditText>(R.id.editC).text.toString().toInt()
                val result = findViewById<TextView>(R.id.tvresults)
                result.text = (a*b*c).toString()

        }
    }
}