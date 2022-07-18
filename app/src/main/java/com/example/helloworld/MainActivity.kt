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
        val buttonShow = binding.buttonShow
        val buttonSqrCalcStart = binding.buttonSqrCalcStart
        val buttonStartCalcute = binding.startCalcute
        buttonShow.setOnClickListener{
            val tvShow = binding.tvHelloWorld
            tvShow.text = getString(R.string.hello_world)
        }
        buttonSqrCalcStart.setOnClickListener{
            val intent = Intent(this, SqrCalc::class.java)
            startActivity(intent)
        }
        buttonStartCalcute.setOnClickListener {
            val intent = Intent(this, CalculateActivity::class.java)
           startActivity(intent)
        }
    }
}