package com.andreamurillo.app_ut2_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.RadioAccessSpecifier
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rgOpcionViaje = findViewById<RadioGroup>(R.id.rgOpcionViaje)
        val switchIva = findViewById<Switch>(R.id.switchIva);
        val btnMostrar = findViewById<Button>(R.id.btnMostrar)

        rgOpcionViaje.setOnCheckedChangeListener{
            rgOpcionViaje, opc -> obtenerPrecio(opc, switchIva.isChecked)
        }

        switchIva.setOnCheckedChangeListener { compoundButton, b ->
            obtenerPrecio(rgOpcionViaje.checkedRadioButtonId, b)
        }

        btnMostrar.setOnClickListener {
            obtenerPrecio(rgOpcionViaje.checkedRadioButtonId, switchIva.isChecked)
        }

        
    }
    private fun obtenerPrecio(radioButtonId: Int, iva: Boolean){
        val txtPrecioFinal = findViewById<TextView>(R.id.txtPrecioFinal)
        val etPresupuesto = findViewById<EditText>(R.id.etPresupuesto)

        var precio: Double = when(radioButtonId){
            R.id.rbPeninsula -> 600.0
            R.id.rbIslas -> 900.0
            else -> 520.0
        }
        if(iva){
            precio = precio*1.21
        }

        txtPrecioFinal.text = "${String.format("%.2f", precio)}€"
        val presupuesto = etPresupuesto.text.toString().toDoubleOrNull()
        if(presupuesto != null){
            if(presupuesto>precio){
                txtPrecioFinal.setTextColor(getColor(R.color.verde))
            }else{
                txtPrecioFinal.setTextColor(getColor(R.color.rojo))
            }
        }
    }
}