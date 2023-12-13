package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpdateActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Funcion sobre el bton_actualizar en el que introducimos el nombre de un propietario y actualizaremos su direccion en la tabla propietarios
        binding.btnActualizar.setOnClickListener{
            var nombre_propietario= binding.nPropietario.text.toString()
            var direccion_propietario= binding.nuevaDireccion.text.toString()
            CoroutineScope(Dispatchers.IO).launch { //Para que se ejecute en un hilo secundario
                MisMascotasApp.database.propietariosDao().actualizarDireccionPropietario(nombre_propietario, direccion_propietario)
            }
        }
    }
}