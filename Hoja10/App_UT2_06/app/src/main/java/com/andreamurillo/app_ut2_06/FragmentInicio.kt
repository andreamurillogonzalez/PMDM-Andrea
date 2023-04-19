package com.andreamurillo.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.andreamurillo.app_ut2_06.databinding.FragmentInicioBinding
import com.andreamurillo.app_ut2_06.databinding.FragmentPersonasBinding

class FragmentInicio : Fragment() {

    private lateinit var binding: FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.botonReptario.setOnClickListener {
            onClick()
        }
        binding.botonZoologico.setOnClickListener {
            onClick()
        }

        binding.botonVisitaGuiada.setOnClickListener {
            onClick()
        }
    }
    fun onClick(){
        view?.findNavController()?.navigate(R.id.action_fragmentInicio_to_fragmentPersonas)
    }

}