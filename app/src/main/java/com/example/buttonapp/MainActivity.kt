package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var tvNumber: TextView
    lateinit var addButton: Button
    lateinit var subButton: Button
    var number = 0

    private lateinit var clMain: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clMain = findViewById(R.id.clMain)
        Snackbar.make(clMain, "This is snackBar", Snackbar.LENGTH_LONG).show()


        tvNumber = findViewById(R.id.number)
        addButton = findViewById(R.id.addButton)
        subButton = findViewById(R.id.subButton)

        addButton.setOnClickListener{ changeNumber(operation = "+") }
        subButton.setOnClickListener{ changeNumber(operation = "-") }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.operation -> {
                Snackbar.make(clMain, "There are several operation, ex: +,-,* and /", Snackbar.LENGTH_LONG).show()
                return true
            }
            R.id.about -> {
                Snackbar.make(clMain, "copyright: Khawlah 2021", Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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