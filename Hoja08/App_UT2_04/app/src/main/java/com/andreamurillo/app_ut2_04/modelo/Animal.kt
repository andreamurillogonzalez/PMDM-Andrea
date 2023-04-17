package com.andreamurillo.app_ut2_04.modelo

import java.io.Serializable

data class Animal(
    val nombre: String,
    val imagenId: Int,
    val descripcion: String
    ): Serializable
