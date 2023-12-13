package com.example.mascotasapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascotas")
data class Mascotas (
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var nombre:String="",
    var esPerro: Boolean = false,
    var raza:String="",
    var fechaNacimiento:String="",
    var duenio : String = ""
)