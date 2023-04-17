package com.andreamurillo.app_ut2_04.datos

import com.andreamurillo.app_ut2_04.R
import com.andreamurillo.app_ut2_04.modelo.Animal

object DatosAnimales
{
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena, "Esto es una ballena", 0),
            Animal("Bisonte", R.drawable.bisonte, "Esto es un bisonte", 0),
            Animal("Camaleón", R.drawable.camaleon, "Esto es un camaleón", 0),
            Animal("Cebra", R.drawable.cebra, "Esto es una cebra", 0),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Esto es un cocodrilo", 0),
            Animal("Elefante", R.drawable.elefante, "Esto es un elefante", 0),
            Animal("Hipopótamo", R.drawable.hipopotamo, "Esto es un hipopótamo", 0),
            Animal("Jirafa", R.drawable.jirafa, "Esto es una jirafa", 0),
            Animal("Mono", R.drawable.mono, "Esto es un mono", 0),
            Animal("Venado", R.drawable.venado, "Esto es un venado", 0),
            Animal("Zorro", R.drawable.zorro, "Esto es un zorro", 0),
        )
    }
}
