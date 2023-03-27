package com.andreamurillo.app_ut2_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val datos = linkedMapOf<String, Int>("Iván" to R.drawable.avatar3,
        "María" to R.drawable.avatar1,
        "Rosa" to R.drawable.avatar2,
        "Pepe" to R.drawable.avatar4)
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCambiar = findViewById<Button>(R.id.btnCambiar);
        val txtNombre = findViewById<TextView>(R.id.txtNombre);
        val imgFoto = findViewById<ImageView>(R.id.imgFoto);

        btnCambiar.setOnClickListener{
            contador++
            contador%=datos.size
            val texto = datos.keys.elementAt(contador)
            txtNombre.text = texto
            imgFoto.setImageResource(datos[texto]!!)
            Toast.makeText(this, "Has cambiado el valor a $texto", Toast.LENGTH_SHORT).show()
        }

    }
}