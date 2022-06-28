package com.example.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.ActivityCalculateBinding
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var operator = ""
        var operatorOn = false
        var firstArgument: Double
        var secondArgument: Double
        var resultFinal = 0.0


        fun showText(text: String){
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

        fun addDot(){
            if ("." !in tvExpression.text.toString()){
                binding.tvExpression.text = binding.tvExpression.text.toString() + binding.tvDot.text
            }
        }

        fun allClear() {
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
            resultFinal = 0.0
            operatorOn = false
        }

        fun dropLastElements(){
            binding.tvExpression.text = binding.tvExpression.text.toString().dropLast(1)
        }

        fun operation (operator: String) {
            if (!operatorOn) {
                binding.tvExpression.text = binding.tvExpression.text.toString() + operator
                operatorOn = true
            }else {
                Toast.makeText(this, "Нажмите равно", Toast.LENGTH_SHORT).show()
            }
        }

        fun clickOperator(operatorSub: String){
            operator = operatorSub
            operation(operatorSub)
        }

        fun buttonClick(buttonId: String){
            binding.tvExpression.text = binding.tvExpression.text.toString() + buttonId
        }

        fun countFinalEquals() {
            var str = binding.tvExpression.text.toString()
            if (operatorOn) {
                if (str.last() != operator[0]) {
                    if (str[0] != operator[0]) {
                        firstArgument = binding.tvExpression.text.toString().substringBefore(operator).toDouble()
                        secondArgument = binding.tvExpression.text.toString().substringAfter(operator).toDouble()
                        resultFinal = 0.0
                    } else {
                        firstArgument = resultFinal
                        secondArgument = binding.tvExpression.text.toString().substringAfter(operator).toDouble()
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
                    binding.tvResult.text = resultFinal.toString()
                    binding.tvExpression.text = ""
                    operatorOn = false
                } else showText("Введите второе число")
            }else showText("Выберите оператор")
        }

        val listener = View.OnClickListener { view ->
            when (view) {
                binding.tvOne -> buttonClick(binding.tvOne.text.toString())
                binding.tvTwo -> buttonClick(binding.tvTwo.text.toString())
                binding.tvThree -> buttonClick(binding.tvThree.text.toString())
                binding.tvFour -> buttonClick(binding.tvFour.text.toString())
                binding.tvFive -> buttonClick(binding.tvFive.text.toString())
                binding.tvSix -> buttonClick(binding.tvSix.text.toString())
                binding.tvSeven -> buttonClick(binding.tvSeven.text.toString())
                binding.tvEight -> buttonClick(binding.tvEight.text.toString())
                binding.tvNine -> buttonClick(binding.tvNine.text.toString())
                binding.tvZero -> buttonClick(binding.tvZero.text.toString())
                binding.tvClear -> allClear()
                binding.tvBack -> dropLastElements()
                binding.tvEquals -> countFinalEquals()
                binding.tvPlus -> clickOperator(binding.tvPlus.text.toString())
                binding.tvMinus -> clickOperator(binding.tvMinus.text.toString())
                binding.tvDivide -> clickOperator(binding.tvDivide.text.toString())
                binding.tvMul -> clickOperator(binding.tvMul.text.toString())
                binding.tvDot -> addDot()
            }
        }
        binding.tvOne.setOnClickListener(listener)
        binding.tvTwo.setOnClickListener(listener)
        binding.tvThree.setOnClickListener(listener)
        binding.tvFour.setOnClickListener(listener)
        binding.tvFive.setOnClickListener(listener)
        binding.tvSix.setOnClickListener(listener)
        binding.tvSeven.setOnClickListener(listener)
        binding.tvEight.setOnClickListener(listener)
        binding.tvNine.setOnClickListener(listener)
        binding.tvZero.setOnClickListener(listener)
        binding.tvClear.setOnClickListener(listener)
        binding.tvBack.setOnClickListener(listener)
        binding.tvEquals.setOnClickListener(listener)
        binding.tvPlus.setOnClickListener (listener)
        binding.tvMinus.setOnClickListener (listener)
        binding.tvDivide.setOnClickListener(listener)
        binding.tvMul.setOnClickListener (listener)
        binding.tvDot.setOnClickListener (listener)
    }
}

