package com.example.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.helloworld.databinding.ActivityMainBinding
import com.example.helloworld.databinding.ActivitySqrCalcBinding
import kotlinx.android.synthetic.main.activity_sqr_calc.*
import java.lang.Math.sqrt

class SqrCalc : AppCompatActivity() {
    lateinit var bindingSqr: ActivitySqrCalcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSqr = ActivitySqrCalcBinding.inflate(layoutInflater)
        setContentView(bindingSqr.root)
        val button_calc_x = bindingSqr.calcx
        val result = bindingSqr.tvresults

        fun descriminantCalc(a:Double, b: Double, c: Double): Double {
            var descriminant: Double = b*b - 4*a*c
            return descriminant
        }

        fun getXone(a:Double, b: Double, c: Double): Double {
            val x1 =  (-b + kotlin.math.sqrt(descriminantCalc(a, b, c))) / (2 * a)
            return (x1)
        }
        fun getXsecond(a:Double, b: Double, c: Double): Double {
            val x2 =  (-b - kotlin.math.sqrt(descriminantCalc(a, b, c))) / (2 * a)
            return (x2)
        }

        fun checkItem(a: String, b:String, c: String):Boolean {
            return if (a.toDoubleOrNull() == null || b.toDoubleOrNull() == null || c.toDoubleOrNull() == null){
                Toast.makeText(this, "Введите число", Toast.LENGTH_LONG).show()
            false
            }
            else true
        }

        fun calcX (a:Double, b: Double, c: Double) {
            val descriminant = descriminantCalc(a, b, c)
            if (descriminant < 0)
                result.text = "Дискриминант меньше нуля, корни комплексны"
            if (descriminant > 0) {
                val x1 = getXone(a, b, c).toString()
                val x2 = getXsecond(a, b, c).toString()
                result.text = "x1= $x1 x2= $x2"
            }else {
                val x1 =  getXone(a,b,c)
                result.text = "x1= $x1 "
            }
        }

        button_calc_x.setOnClickListener{
                val a = bindingSqr.editA.text.toString()
                val b = bindingSqr.editB.text.toString()
                val c = bindingSqr.editC.text.toString()
                if (checkItem(a,b,c))
                    calcX(a.toDouble(), b.toDouble(), c.toDouble())
        }
    }
}