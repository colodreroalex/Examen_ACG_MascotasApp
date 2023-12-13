package com.example.mascotasapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface PropietariosDao {

    @Insert
    fun addPropietario(propietario:Propietarios)

    @Transaction
    @Query("SELECT * FROM propietarios WHERE nombre_propietario like :propietario")
    fun mascotasDeUnPropietario(propietario:String):PropietarioConMascotas

    @Delete
    fun borrarPropietario(propietario:Propietarios)

    @Query("Update propietarios set direccion_propietario = :direccion where nombre_propietario like :nombre")
    fun actualizarDireccionPropietario(nombre:String, direccion:String)
}