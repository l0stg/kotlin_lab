package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.finalcalculator.CalculateActivity
import com.example.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button_show = binding.buttonShow
        val button_sqr_calc_start = binding.buttonSqrCalcStart
        val button_start_calcute = binding.startCalcute
        button_show.setOnClickListener{
            val tvShow = binding.tvHelloWorld
            tvShow.text = getString(R.string.hello_world)
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