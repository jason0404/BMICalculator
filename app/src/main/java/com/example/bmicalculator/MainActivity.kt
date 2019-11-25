package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                val weight = findViewById<EditText>(R.id.weight)
                val height = findViewById<EditText>(R.id.height)

                val btn: Button = findViewById(R.id.button)
                val btn1:Button = findViewById(R.id.button2)

                btn.setOnClickListener(){
                    calculate(weight.text.toString().toDouble(),height.text.toString().toDouble())
                }

                btn1.setOnClickListener(){
                    val img: ImageView = findViewById(R.id.imageView)
                    val weight1: EditText = findViewById(R.id.weight)
                    weight1.setText("")

                    val height1: EditText = findViewById(R.id.height)
                    height1.setText("")

                    img.setImageResource(R.drawable.empty)
                }
    }

    fun calculate(weight: Double, height: Double) {
        val img: ImageView = findViewById(R.id.imageView)
        var result: Double = (weight / (height).pow(2))


        if (result < 18.5) {
            img.setImageResource(R.drawable.under)

            Toast.makeText(applicationContext, "BMI %.2f".format(result), Toast.LENGTH_SHORT).show()
        } else if (result > 18.5 && result < 24.9) {
            img.setImageResource(R.drawable.normal)
            Toast.makeText(applicationContext, "BMI %.2f".format(result), Toast.LENGTH_SHORT).show()
        } else if (result > 25) {
            img.setImageResource(R.drawable.over)
            Toast.makeText(applicationContext, "BMI %.2f".format(result), Toast.LENGTH_SHORT).show()
        } else {
            img.setImageResource(R.drawable.empty)
            Toast.makeText(applicationContext, "Invalid", Toast.LENGTH_SHORT).show()
        }
    }
}
