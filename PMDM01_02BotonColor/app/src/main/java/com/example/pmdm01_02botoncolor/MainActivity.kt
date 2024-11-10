package com.example.pmdm01_02botoncolor

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private val colors = listOf(R.color.green, R.color.red, R.color.yellow, R.color.blue)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val colorButton = findViewById<Button>(R.id.colorButton)
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)

        var index = 0
        colorButton.setOnClickListener {
            index = (index + 1) % colors.size
            val actualColor = ContextCompat.getColor(this, colors[index])
            mainLayout.setBackgroundColor(actualColor)
        }

    }
}