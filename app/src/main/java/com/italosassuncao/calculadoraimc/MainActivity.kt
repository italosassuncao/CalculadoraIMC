package com.italosassuncao.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonCalcular = findViewById(R.id.buttonCalcular)
        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)

        buttonCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()) {
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}