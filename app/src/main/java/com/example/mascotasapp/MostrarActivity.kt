package com.example.mascotasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mascotasapp.database.MisMascotasApp
import com.example.mascotasapp.databinding.ActivityMostrarBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MostrarActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMostrarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnMostrar.setOnClickListener{
            var nombre_propietario= binding.nPropietario.text.toString()
            CoroutineScope(Dispatchers.IO).launch { //Para que se ejecute en un hilo secundario
                val numPerros = MisMascotasApp.database.mascotasDao().getNumPerros(nombre_propietario)
                val numGatos = MisMascotasApp.database.mascotasDao().getNumGatos(nombre_propietario)

                //Para que se ejecute en el hilo principal
                withContext(Dispatchers.Main) {
                    binding.numPerros.text = "Número de perros: $numPerros"
                    binding.numGatos.text = "Número de gatos: $numGatos"
                }
            }
        }
    }
}