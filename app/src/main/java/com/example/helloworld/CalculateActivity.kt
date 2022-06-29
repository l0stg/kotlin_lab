package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.helloworld.databinding.ActivityCalculateBinding
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var operator = ""
        var firstArgument = 0.0
        var secondArgument = 0.0
        var resultFinal = 0.0
        var bool = false

        fun countSchet():Double {
            when (operator) {
                "+" -> resultFinal = firstArgument + secondArgument
                "-" -> resultFinal = firstArgument - secondArgument
                "/" -> {
                    if (firstArgument == 0.0 && secondArgument == 0.0)
                        resultFinal = 1.0
                    else if (firstArgument.toString() != "0"  && secondArgument == 0.0)
                        bool = true
                    else
                        firstArgument / secondArgument
                }
                "*" -> resultFinal = firstArgument * secondArgument
            }
            return (resultFinal)
        }

        fun addDot() {
            if ("." !in tvExpression.text.toString()) {
                binding.tvExpression.text =
                    binding.tvExpression.text.toString() + binding.tvDot.text
            }
        }

        fun allClear() {
            binding.tvExpression.text = ""
            resultFinal = 0.0
        }

        fun dropLastElements() {
            binding.tvExpression.text = binding.tvExpression.text.toString().dropLast(1)
        }

        fun showResults(resultFinal1: Double) {
            allClear()
            if (bool)
                binding.tvExpression.text = "Делить на ноль нельзя"
            else
                binding.tvExpression.text = resultFinal1.toString()
        }

        fun countFinalEquals() {
            secondArgument = binding.tvExpression.text.toString().toDouble()
            var resultFinal1 = countSchet()
            showResults(resultFinal1)
        }

        fun clickOperator(operatorSub: String) {
            if(binding.tvExpression.text != "") {
                    operator = operatorSub
                    firstArgument = binding.tvExpression.text.toString().toDouble()
                    allClear()
                }
            }

        val listener = View.OnClickListener { view ->
            when (view) {
                binding.tvClear -> allClear()
                binding.tvBack -> dropLastElements()
                binding.tvEquals -> countFinalEquals()
                binding.tvDot -> addDot()
            }
        }
        binding.tvClear.setOnClickListener(listener)
        binding.tvBack.setOnClickListener(listener)
        binding.tvEquals.setOnClickListener(listener)
        binding.tvDot.setOnClickListener(listener)

        listOf(
            binding.tvPlus, binding.tvMinus,
            binding.tvDivide, binding.tvMul
        ).forEach { btn -> btn.setOnClickListener {
                clickOperator(btn.text.toString())
             }
        }

        listOf(
            binding.tvOne, binding.tvTwo, binding.tvThree,
            binding.tvFour, binding.tvFive, binding.tvSix,
            binding.tvSeven, binding.tvEight, binding.tvNine,
            binding.tvZero
        ).forEach { btn -> btn.setOnClickListener {
            val currentValue = binding.tvExpression.text
            val newValue = btn.text
            val text =
                if (currentValue == "0") {
                    newValue
                } else "$currentValue$newValue"
            binding.tvExpression.text = text
        }
        }
    }
}