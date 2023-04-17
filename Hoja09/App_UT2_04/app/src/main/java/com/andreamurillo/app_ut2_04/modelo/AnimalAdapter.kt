package com.andreamurillo.app_ut2_04.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andreamurillo.app_ut2_04.R
import com.andreamurillo.app_ut2_04.databinding.ActivityDetalleAnimalBinding
import com.andreamurillo.app_ut2_04.datos.DatosAnimales

class AnimalAdapter(private val onClickAnimal: (Animal) -> Unit): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{
    private val listaAnimales = DatosAnimales.getDatosAnimales()

    class AnimalViewHolder(view: View,private val onClickAnimal: (Int) -> Unit): RecyclerView.ViewHolder(view)
    {

        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)
        val imageViewAnimal = view.findViewById<ImageView>(R.id.imageViewAnimal)
        val txtVotos = view.findViewById<TextView>(R.id.txtVotos)
        init {
            view.setOnClickListener { onClickAnimal(adapterPosition) }
        }
    }
    fun addAnimal(nombreAnimal: String)
    {
        val animal = Animal(nombreAnimal, R.drawable.desconocido, "Animal desconocido", 0)
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }

    fun cambiarVoto(nombre: String, voto: Int){
        val animal = listaAnimales.first{a -> a.nombre == nombre}
        animal.votos +=voto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout){pos -> onClickAnimal(listaAnimales[pos])}
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imageViewAnimal.setImageResource(animal.imagenId)
        holder.txtVotos.text = animal.votos.toString() + " votos"
    }

    override fun getItemCount(): Int {
        return listaAnimales.size
    }
}
