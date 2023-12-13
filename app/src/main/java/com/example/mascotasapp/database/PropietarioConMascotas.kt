package com.example.mascotasapp.database

import androidx.room.Embedded
import androidx.room.Relation

data class PropietarioConMascotas (
    @Embedded val propietario: Propietarios,

    @Relation(
        parentColumn = "nombre_propietario",
        entityColumn = "duenio"
    )

    val mascotas: MutableList<Mascotas>
)