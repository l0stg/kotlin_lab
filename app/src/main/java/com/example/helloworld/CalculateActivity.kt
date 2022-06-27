package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.databinding.ActivityCalculateBinding
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var tvinput = binding.tvExpression
        var tvresult = binding.tvResult
        var tvinputStr = ""
        var operator = ""
        var operatorOn = false
        var firstArgument: Double
        var secondArgument: Double
        var resultFinal = 0.0
        var dotFlag = false

        fun allClear() {
            tvinput.text = ""
            tvresult.text = ""
            resultFinal = 0.0
            dotFlag = false
            operatorOn = false
        }

        fun Operation (operator: String) {
            if (operatorOn == false) {
                tvinput.text = tvinput.text.toString() + operator
                operatorOn = true
            }else {
                Toast.makeText(this, "Нажмите равно", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvOne.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "1"
            tvinput.text = tvinputStr
        }

        binding.tvTwo.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "2"
            tvinput.text = tvinputStr
        }

        binding.tvThree.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "3"
            tvinput.text = tvinputStr
        }

        binding.tvFour.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "4"
            tvinput.text = tvinputStr
        }

        binding.tvFive.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "5"
            tvinput.text = tvinputStr
        }

        binding.tvSix.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "6"
            tvinput.text = tvinputStr
        }

        binding.tvSeven.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "7"
            tvinput.text= tvinputStr
        }

        binding.tvEight.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "8"
            tvinput.text = tvinputStr
        }

        binding.tvNine.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "9"
            tvinput.text = tvinputStr
        }

        binding.tvZero.setOnClickListener {
            tvinputStr = tvinput.text.toString()
            tvinputStr += "0"
            tvinput.text = tvinputStr
        }

        binding.tvClear.setOnClickListener {
            allClear()
        }

        binding.tvBack.setOnClickListener {
            tvinputStr = tvinputStr.dropLast(1)
            tvinput.text = tvinputStr
        }

        binding.tvEquals.setOnClickListener {

            var str = tvinput.text.toString()
            if (operatorOn == true) {
                if (str.last() != operator[0]) {
                    if (str[0] != operator[0]) {
                        firstArgument = tvinput.text.toString().substringBefore(operator).toDouble()
                        secondArgument = tvinput.text.toString().substringAfter(operator).toDouble()
                        resultFinal = 0.0
                    } else {
                        firstArgument = resultFinal
                        secondArgument = tvinput.text.toString().substringAfter(operator).toDouble()
                    }
                    when (operator) {
                        "+" -> resultFinal = firstArgument + secondArgument
                        "-" -> resultFinal = firstArgument - secondArgument
                        "/" -> {
                            if (firstArgument == 0.0 && secondArgument == 0.0)
                                resultFinal = 1.0
                            else
                                resultFinal = firstArgument / secondArgument
                        }
                        "*" -> resultFinal = firstArgument * secondArgument
                    }
                    tvresult.text = resultFinal.toString()
                    tvinput.text = ""
                    operatorOn = false
                    dotFlag = false
                } else Toast.makeText(this, "Введите второе число", Toast.LENGTH_LONG).show()
            }else Toast.makeText(this, "Выберите оператор", Toast.LENGTH_LONG).show()
        }

        binding.tvPlus.setOnClickListener {
            operator = "+"
            Operation(operator)
        }

        binding.tvMinus.setOnClickListener {
            operator = "-"
            Operation(operator)
        }

        binding.tvDivide.setOnClickListener{
            operator = "/"
            Operation(operator)
        }

        binding.tvMul.setOnClickListener {
            operator = "*"
            Operation(operator)
        }
        binding.tvDot.setOnClickListener {
            if (dotFlag == false){
                tvinputStr = tvinput.text.toString()
                tvinputStr += "."
                tvinput.text = tvinputStr
                dotFlag = true
            }
        }

    }
}

