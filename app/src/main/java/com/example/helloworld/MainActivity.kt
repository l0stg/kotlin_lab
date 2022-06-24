package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_show = findViewById<Button>(R.id.buttonShow)
        val button_sqr_calc_start = findViewById<Button>(R.id.buttonSqrCalcStart)
        val button_start_calcute = findViewById<Button>(R.id.startCalcute)
        button_show.setOnClickListener{
            val tvShow = findViewById<TextView>(R.id.tvHelloWorld)
            tvShow.text = "Привет мир"
        }
        button_sqr_calc_start.setOnClickListener{
            val intent = Intent(this, SqrCalc::class.java)
            startActivity(intent)
        }
        button_start_calcute.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
            startActivity(intent)
        }
    }
}