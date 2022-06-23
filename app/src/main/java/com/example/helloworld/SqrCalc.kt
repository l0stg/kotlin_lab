package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.sqrt

class SqrCalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqr_calc)
        val button_calc_x = findViewById<Button>(R.id.calc_x)

        fun descriminantCalc(a:Double, b: Double, c: Double): Double {
            var descriminant: Double = b*b - 4*a*c
            return descriminant
        }

        fun x_one(a:Double, b: Double, c: Double): Double {
            val x1 =  (-b + kotlin.math.sqrt(descriminantCalc(a, b, c))) / (2 * a)
            return (x1)
        }
        fun x_second(a:Double, b: Double, c: Double): Double {
            val x2 =  (-b - kotlin.math.sqrt(descriminantCalc(a, b, c))) / (2 * a)
            return (x2)
        }

        button_calc_x.setOnClickListener{
                val a: Double = findViewById<EditText>(R.id.editA).text.toString().toDouble()
                val b: Double = findViewById<EditText>(R.id.editB).text.toString().toDouble()
                val c: Double = findViewById<EditText>(R.id.editC).text.toString().toDouble()
                val xone = x_one(a, b, c).toString()
                val xsecond = x_second(a, b, c).toString()
                val result = findViewById<TextView>(R.id.tvresults)
                result.text = "x1= $xone и x2= $xsecond"

        }
    }
}