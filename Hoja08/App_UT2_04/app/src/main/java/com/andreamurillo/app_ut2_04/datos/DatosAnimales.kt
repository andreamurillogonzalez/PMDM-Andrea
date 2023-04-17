package com.andreamurillo.app_ut2_04.datos

import com.andreamurillo.app_ut2_04.R
import com.andreamurillo.app_ut2_04.modelo.Animal

object DatosAnimales
{
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena, "Esto es una ballena"),
            Animal("Bisonte", R.drawable.bisonte, "Esto es un bisonte"),
            Animal("Camaleón", R.drawable.camaleon, "Esto es un camaleón"),
            Animal("Cebra", R.drawable.cebra, "Esto es una cebra"),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Esto es un cocodrilo"),
            Animal("Elefante", R.drawable.elefante, "Esto es un elefante"),
            Animal("Hipopótamo", R.drawable.hipopotamo, "Esto es un hipopótamo"),
            Animal("Jirafa", R.drawable.jirafa, "Esto es una jirafa"),
            Animal("Mono", R.drawable.mono, "Esto es un mono"),
            Animal("Venado", R.drawable.venado, "Esto es un venado"),
            Animal("Zorro", R.drawable.zorro, "Esto es un zorro"),
        )
    }
}
