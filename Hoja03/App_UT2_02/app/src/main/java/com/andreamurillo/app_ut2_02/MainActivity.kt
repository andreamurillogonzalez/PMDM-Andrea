package com.andreamurillo.app_ut2_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var contador = 0

        val btnContar = findViewById<Button>(R.id.btnContar)
        val btnMostrarToast = findViewById<Button>(R.id.btnMostrarToast)
        val txtContador  = findViewById<TextView>(R.id.txtContador)
        btnContar.setOnClickListener{
            contador++
            txtContador.text = contador.toString()
        }
        btnMostrarToast.setOnClickListener {
            Toast.makeText(this, "Se ha pulsado el botón $contador veces", Toast.LENGTH_SHORT).show()
        }
    }
}