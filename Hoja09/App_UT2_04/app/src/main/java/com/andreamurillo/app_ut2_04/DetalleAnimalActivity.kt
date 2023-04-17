package com.andreamurillo.app_ut2_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andreamurillo.app_ut2_04.databinding.ActivityDetalleAnimalBinding
import com.andreamurillo.app_ut2_04.modelo.Animal

class DetalleAnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleAnimalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = intent.extras?.get("animal") as Animal

        binding.ivAnimal.setImageResource(animal.imagenId)
        binding.txtNombre.text = animal.nombre
        binding.txtDescripcion.text = animal.descripcion

        binding.btnPositivo.setOnClickListener {
            crearIntentAMain(animal, 1)
        }
        binding.btnNegativo.setOnClickListener {
            crearIntentAMain(animal, -1)
        }

    }
    fun crearIntentAMain(animal: Animal, voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK, intentDevuelto)
        finish()
    }
}