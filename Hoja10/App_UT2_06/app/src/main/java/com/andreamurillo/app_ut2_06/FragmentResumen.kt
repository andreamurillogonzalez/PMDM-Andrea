package com.andreamurillo.app_ut2_06

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.andreamurillo.app_ut2_06.databinding.FragmentFechaBinding
import com.andreamurillo.app_ut2_06.databinding.FragmentResumenBinding

class FragmentResumen : Fragment() {

    private lateinit var binding: FragmentResumenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.botonReservar.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragmentResumen_to_fragmentInicio)
        }
    }


}