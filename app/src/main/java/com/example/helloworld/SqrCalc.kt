package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.sqrt

class SqrCalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqr_calc)
        val button_calc_x = findViewById<Button>(R.id.calc_x)
        val result = findViewById<TextView>(R.id.tvresults)

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

        fun CheckItem(a: String, b:String, c: String):Boolean {
            return if (a.toDoubleOrNull() == null || b.toDoubleOrNull() == null || c.toDoubleOrNull() == null){
                Toast.makeText(this, "Введите число", Toast.LENGTH_LONG).show()
            false
            }
            else true
        }
        
        fun CalcX (a:Double, b: Double, c: Double) {
            val descriminant = descriminantCalc(a, b, c)
            if (descriminant < 0)
                result.text = "Дискриминант меньше нуля, корни комплексны"
            if (descriminant > 0) {
                val x1 = x_one(a, b, c).toString()
                val x2 = x_second(a, b, c).toString()
                result.text = "x1= $x1 x2= $x2"
            }else {
                val x1 = x_one(a,b,c)
                result.text = "x1= $x1 "
            }
        }

        button_calc_x.setOnClickListener{
                val a = findViewById<EditText>(R.id.editA).text.toString()
                val b = findViewById<EditText>(R.id.editB).text.toString()
                val c = findViewById<EditText>(R.id.editC).text.toString()
                if (CheckItem(a,b,c))
                    CalcX(a.toDouble(), b.toDouble(), c.toDouble())
        }
    }
}