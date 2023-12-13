package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityDeleteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DeleteActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Funcion sobre el bton_eliminar en el que introducimos el nombre
        // del propietario y deberan eliminarse de la tabla mascostas todas las mascotas de ese propietario
        binding.btonEliminar.setOnClickListener{
            var nombre_propietario= binding.escribePropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch { //Para que se ejecute en un hilo secundario
                MisMascotasApp.database.mascotasDao().borrarMascota(nombre_propietario)
            }
        }
    }
}