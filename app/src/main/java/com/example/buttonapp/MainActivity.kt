package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvNumber: TextView
    lateinit var addButton: Button
    lateinit var subButton: Button
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.number)
        addButton = findViewById(R.id.addButton)
        subButton = findViewById(R.id.subButton)

        addButton.setOnClickListener{ changeNumber(operation = "+") }
        subButton.setOnClickListener{ changeNumber(operation = "-") }
    }

    private fun changeNumber(operation: String) {
        when (operation) {
            "+" -> ++number
            "-" -> --number
        }
        tvNumber.text = "$number"

        // Change the color of the number based on its value.
        when {
            number == 0 -> tvNumber.setTextColor(Color.BLACK) // 0 - black
            number > 0 -> tvNumber.setTextColor(Color.GREEN) // positive - green
            else -> tvNumber.setTextColor(Color.RED) // negative - red

        }

    }
}