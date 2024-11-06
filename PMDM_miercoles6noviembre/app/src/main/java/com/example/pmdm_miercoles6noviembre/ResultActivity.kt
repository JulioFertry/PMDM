package com.example.pmdm_miercoles6noviembre
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val textoRes = findViewById<AppCompatTextView>(R.id.textoFinal)
        val nombre = intent.extras?.getString("EXTRA_NAME").orEmpty()
        textoRes.text = nombre
    }
}