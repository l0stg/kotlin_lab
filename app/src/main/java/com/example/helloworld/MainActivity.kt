package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    fun toastMeState(message: String) {
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }
    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }
    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }
    override fun onPostResume() {
        super.onPostResume()
        toastMeState("onPostResume")
    }
    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }
    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }
    override fun onRestart() {
        super.onRestart()
        toastMeState("onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        toastMeState("ON_CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_show = findViewById<Button>(R.id.buttonShow)
        val button_sqr_calc_start = findViewById<Button>(R.id.buttonSqrCalcStart)
        button_show.setOnClickListener{
            val tvShow = findViewById<TextView>(R.id.tvHelloWorld)
            tvShow.text = "Привет мир"
        }
        button_sqr_calc_start.setOnClickListener{
            val intent = Intent(this, SqrCalc::class.java)
            startActivity(intent)
        }


    }
}