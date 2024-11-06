package com.example.pmdm_miercoles6noviembre
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val textoEdit = findViewById<EditText>(R.id.textoEdit)

        val textito = textoEdit.text.toString()


        btnEnviar.setOnClickListener {
            if (textito.isNotEmpty()){
                val intento = Intent(this, ResultActivity::class.java)
                intento.putExtra("EXTRA_NAME", textito)
                startActivity(intento)
            }
        }
    }
}