package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MascotasDao {
    @Insert
    fun addMascota(mascota:Mascotas)

    @Query("DELETE FROM MASCOTAS WHERE duenio like :nombre_propietario")
    fun borrarMascota(nombre_propietario:String)

    @Update
    fun updateMascota(mascota:Mascotas)

    @Query("SELECT COUNT(*) FROM MASCOTAS WHERE duenio like :duenio_name AND esPerro = 1 ")
    fun getNumPerros(duenio_name: String):Int

    @Query("SELECT COUNT(*) FROM MASCOTAS WHERE duenio like :duenio_name AND esPerro = 0 ")
    fun getNumGatos(duenio_name: String):Int
}