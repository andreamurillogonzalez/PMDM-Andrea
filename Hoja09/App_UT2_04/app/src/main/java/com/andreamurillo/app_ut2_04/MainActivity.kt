package com.andreamurillo.app_ut2_04

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreamurillo.app_ut2_04.modelo.Animal
import com.andreamurillo.app_ut2_04.modelo.AnimalAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == Activity.RESULT_OK){
                val voto = it.data?.getIntExtra("voto", 0)?:0
                val nombre = it.data?.getStringExtra("animal")?:""
                (recyclerView.adapter as AnimalAdapter).cambiarVoto(nombre, voto)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL)
        )
        recyclerView.adapter = AnimalAdapter(){ animal -> onClickAnimal(animal)}
        val botonAnadir = findViewById<FloatingActionButton>(R.id.btnAniadir)
        botonAnadir.setOnClickListener {
            dialogoNuevoAnimal()
        }
    }

    private fun onClickAnimal(animal: Animal)
    {
        val intent = Intent(applicationContext, DetalleAnimalActivity::class.java)
        intent.putExtra("animal", animal)
        segundaActivityLauncher.launch(intent)
    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo animal")
            .setMessage("Introduce el nombre de un nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir") { _, _ ->
                val nuevoAnimal = inputEditTextField .text.toString()
                (recyclerView.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }
}